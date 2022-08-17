# -*- coding: utf-8 -*-
"""
Created on Tue Aug  9 09:47:34 2022

@author: User
"""

import pandas as pd
import matplotlib.pyplot as plt
from datetime import date
from psequant import get_pse_data

#user inputs
company = input("Company(initials): ")
company = company.upper()
name = input("Enter your name:")
interval = int(input("Choose interval: \n1. Monthly\n2. quarterly\n"+
                     "3. semi annually\n4. annually\n"))
investment = float(input("Enter investment: "))
date_of_investment = input("Date of investment (y-m-d): ")

date_split = date_of_investment.split("-")
for i in range(0, len(date_split)):
    date_split[i] = int(date_split[i])

#reading the stockmarket dataframe
data = get_pse_data(company, date_of_investment,str(date.today()))

#creating list for date indexing
df_date_index = [None] * len(data)
df_month_index = [data.index.month[0]]

#inserting month code to df_month_index list from data df
ind= 0
for i in data.index.month:
    if df_month_index[ind] != i:
        df_month_index.append(i) 
        ind = ind + 1
    
#inserting the values from df_month_index to df_date_index    
ind =0  
while ind < len(df_month_index):
    df_date_index[ind] = df_month_index[ind]
    ind = ind + 1

#Creating df_final_date df
#Transfering the values of data DateTimeIndex to df_final_date 
#according to df_date_index list
ind =0 
df_final_date = []
df_yearly_date = []
df_yearly = []

for i in data.index:
    if i.year not in df_yearly and i.month == date_split[1]:
        df_yearly.append(i.year)
        df_yearly_date.append(i)
        ind = ind + 1
inter = 0.0
if interval == 1 or interval ==2 or interval ==3:
    if interval == 1:
        interval_index = 1
        inter = 12.0
    elif interval == 2:
        interval_index = 3
        inter = 4.0
    elif interval == 3:
        interval_index = 6
        inter = 2
    ind=0
    for i in data.index:
        if i.month == df_date_index[ind]:
            df_final_date.append(i)
            ind = ind + interval_index

elif interval ==4:
    df_final_date = df_yearly_date
    inter = 1
        
    
#for i in range(0, len(), 3):
  #  share = investment/final_df["close".casefold()][i]
   # total_shares = total_shares + share
    #shares.append(share)
    #quarterly_list.append(final_df.index)

ftotal_shares = 0.0
fshares = []
ytotal_shares = 0.0
yshares = []


#Setting interval by month
#df = pd.date_range(start='2010-01-01', end=str(date.today()), freq='MS')

def func(df): 
    #puting df_final_date list into dataframe final_df pandas dataframe
    final_df = pd.DataFrame(df)
    
    #Mapping the dataTimeindex of final_df into the original dataframe from PSE    
    closeColumn = dict(zip(data.index,data.close))
    final_df["close"] = final_df[0].map(closeColumn)
    
    #Customizing the Dataframe
    final_df.rename(columns = {0:'date'}, inplace = True)
    final_df.set_index('date', inplace=True)
    
    return final_df



final_df = func(df_final_date)
year_df = func(df_yearly_date)


yroi = []

yca = []
#Looping through the final_df dataframe and perform functions


for i in final_df.index:
    fshare = investment/final_df["close".casefold()][i]
    ftotal_shares = ftotal_shares + fshare
    fshares.append(fshare)
year = 1    
for i in year_df.index:
    yshare = (investment*inter)/year_df["close".casefold()][i]
    ytotal_shares = ytotal_shares + yshare
    yshares.append(yshare)
    yro = round(ytotal_shares*final_df["close"][i],2)
    yroi.append(yro)
    yca.append((((yro/(investment*inter)) ** (1/year)) - 1) * (100))
    year = year + 1  


    

#getting the latest stock price of the company
last_index = len(data)-1
latest_stock_price = data['close'].values[last_index]

#customizing the dataframe
total_investment = investment*len(final_df)
final_df.rename(columns = {'Close'.casefold():'Stock Price'.casefold()}, inplace = True)
final_df["Shares".casefold()] = fshares
final_df["Investment".casefold()] = 1000.0


#customizing the dataframe

year_df.rename(columns = {'Close'.casefold():'Stock Price'.casefold()}, inplace = True)
year_df["Shares".casefold()] = yshares
year_df["Investment".casefold()] = 1000.0*inter

#cagr = final_df.groupby(final_df.index.year).sum()
#a = final_df.reset_index().groupby(pd.Grouper(key='date', freq='1Y')).sum()


#print(a)



year_df['roi'] = yroi
year_df['ca'] = yca





    

if data.index.year[0] != date_split[0] and data.index.month[0] != date_split[1]:
    print("Note: " + company + " started in ", data.index[0])

#printing
print(final_df[["Stock Price".casefold(),"Investment".casefold(),"Shares".casefold()]]) 
print(year_df[["Stock Price".casefold(),"Investment".casefold(),"Shares".casefold(),"roi", "ca"]]) 
print("\n\nWelcome to " + company + " "  + name + "!")
print("\nTotal investment:",total_investment)
#print("Total shares:",round(total_shares,2))
print("Latest Stock Price:",latest_stock_price)

#Customizing the Graph
if final_df["Stock Price".casefold()][0] < final_df["Stock Price".casefold()][i]:
    price_stock_change = round((final_df["Stock Price".casefold()][i]-final_df["Stock Price".casefold()][0])/final_df["Stock Price".casefold()][0]*100,2)
    change = "up " + str(price_stock_change)
    line_color = 'green'
elif final_df["Stock Price".casefold()][0] > final_df["Stock Price".casefold()][i]:
    price_stock_change = round((final_df["Stock Price".casefold()][0]-final_df["Stock Price".casefold()][i])/final_df["Stock Price".casefold()][0]*100,2)
    change = "down " + str(price_stock_change)
    line_color = 'red'

final_df["Stock Price".casefold()].plot(figsize=(20,12),color=line_color)
plt.title("Stock Price -> " + change + "%", fontsize=30)
plt.show()

#user input either the investor wants to cashout or not
cashout = input("Cashout today? y/n")
if cashout == 'y':
    #Computing the ROI
    roi = ytotal_shares * latest_stock_price
    print("\nReturn of Investment:",roi)
    
    #computing the profit
    profit = roi-total_investment
    profit_percentage = profit/total_investment*100
    if roi > total_investment:
        print("You gained ", round(profit,2) , "or", round(profit_percentage,2), 
              "% from your total investment")
        
    elif roi < total_investment:
        print("You lost ", round(profit,2) , "or", round(profit_percentage,2), 
              "% from your total investment")   
        
    print("\nThank you & Come Again!")
else:    
    print("\nThank you & Come Again!")

data.to_csv(company +".csv")
#final_df.to_csv(company +".csv")