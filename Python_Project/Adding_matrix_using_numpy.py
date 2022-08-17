import numpy as np
  
rows = int(input("Enter the number of rows:"))
cols = int(input("Enter the number of columns:"))

print("Enter values for a Matrix: ")
aEntries = list(map(int, input().split()))
a = np.array(aEntries).reshape(rows, cols)

print("Enter values for b matrix: ")
bEntries = list(map(int, input().split()))
b = np.array(bEntries).reshape(rows, cols)

print(a, "\n   +\n", b)
c = np.add(a, b) 
print ("--------\n", c) 