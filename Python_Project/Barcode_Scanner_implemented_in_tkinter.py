# -*- coding: utf-8 -*-
"""
Created on Thu Jun  9 15:38:16 2022

@author: User
"""

#Import the required Libraries
import cv2
from tkinter import *
from pyzbar import pyzbar
from barcode import *
import tkinter.messagebox
import pandas as pd

os.chdir(r"C:\Users\User\Desktop\Freshbuys\1st Week")
dataset = pd.read_csv("data.csv")
list_barcodes = []

#Create an instance of Tkinter frame
win= tkinter.Tk()
win.title('Barcode Scanner')

#Set the geometry of Tkinter frame
win.geometry("750x250")


list_codes = []

def display_text():
   global entry
   list_codes.clear()
   string = entry.get()
   label.configure(text=string)
   Code128(string)
   
   
def download_text():
   global entry
   
   string = entry.get()
   label.configure(text=string)
   
   if string not in list_codes:
       Code128(string).save(string)
       list_codes.append(string)
       tkinter.messagebox.showinfo("Downloaded",  "Successfully Downloaded")
    
   else:
        tkinter.messagebox.showwarning("Downloaded",  "Already Downloaded")

    
def read_barcodes(frame):
    list_barcodes.clear()
    barcodes = pyzbar.decode(frame)
    
    for barcode in barcodes:
        
        x, y , w, h = barcode.rect
        #1
        barcode_info = barcode.data.decode('utf-8')
        
        cv2.rectangle(frame, (x, y),(x+w, y+h), (0, 255, 0), 2)
        
        #2
        font = cv2.FONT_HERSHEY_DUPLEX
        cv2.putText(frame, barcode_info, (x + 6, y - 6), font, 2.0, (255, 255, 255), 1)
        #3
        with open("barcode_result.txt", mode ='w') as file:
            file.write("Barcode:" + barcode_info + "\nPrice: 100")
        
        product = dataset['PRODUCT']
         
        index = dataset[dataset["FB CODE"] == barcode_info].index.values
        if barcode_info in dataset["FB CODE"].values:
            ind = int(index)
            tkinter.messagebox.showinfo("PRODUCT",  "PRODUCT: " + str(dataset.iloc[ind]['PRODUCT'] + "\nPRICE: "))

        else:
            tkinter.messagebox.showerror("Opppss..",  "No Product Found for " + str(barcode_info))
            break
        
        
    return frame




def main():
    #1
    camera = cv2.VideoCapture(0)
    ret, frame = camera.read()
    
 
    #2
    while ret:
        ret, frame = camera.read()
        frame = read_barcodes(frame)
        cv2.imshow('SCANNER', frame)
        
        if cv2.waitKey(10) & 0xFF == 27:
            break
    #3
    camera.release()
    cv2.destroyAllWindows()


#Initialize a Label to display the User Input
label=Label(win, text="|___________|", font=("Courier 22 bold"))
label.pack()
label1=Label(win, text="RESULTS", font=("Courier 22"))
label1.pack()
label1=Label(win, text="WELCOME TO BARCODER", font=("Courier 30 bold"))
label1.pack()


#Create an Entry widget to accept User Input
entry= Entry(win, width= 40)
entry.focus_set()
entry.pack()

#Create a Button to validate Entry Widget
btn = Button(win, text= "Generate",width= 20, bg='#3D550C', fg='gray', command= display_text).pack(pady=10)
btn1 = Button(win, text= "Scan",width= 20, bg='#3D550C', fg='gray', command=main).pack(pady=0)
btn2 = Button(win, text= "Download",width= 10, bg='#3D550C', fg='gray',command = download_text )
btn2.place(x=650,y=10)



win.mainloop()