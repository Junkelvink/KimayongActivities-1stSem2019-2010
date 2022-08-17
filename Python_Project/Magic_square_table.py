
ind = 1
dec = True
while dec == True:
    size = int(input("Enter Size: "))
    print(size, "x", size, "magic square")
    list1 = [[0 for x in range(size)] 
                for y in range(size)] 
    i = size / 2
    j = size - 1
    while ind <= (size * size): 
        if i == -1 and j == size: 
            j = size - 2
            i = 0
        else:  
                
            if j == size: 
                j = 0    
                
            if i < 0: 
                    i = size - 1
        if list1[int(i)][int(j)]: 
            j = j - 2
            i = i + 1
            continue
        else: 
            list1[int(i)][int(j)] = ind 
            ind = ind + 1
        j = j + 1
        i = i - 1 
      
        
    for i in range(0, size): 
        for j in range(0, size): 
            print('%2d ' % (list1[i][j]),end = '') 
                
            if j == size - 1:  
                print()
                
    choice = input("Y/N")
    if choice.lower() == "y":
        dec == True
    elif choice.lower() == "n":
        break;