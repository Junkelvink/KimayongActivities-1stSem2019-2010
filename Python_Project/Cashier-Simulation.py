    
def compute(bill, payment):
    return payment - bill

def process():
    bill = float(input("Bill: "))
    payment = float(input("Payment: "))
    change = compute(bill,payment)
    initialChange = change
    
    print("Your change is", round(change, 2), "\n\nThe machine will now dispense your change:")
    
    denom = [1000.00,500.00,200.00,100.00,50.00,20.00,10.00,5.00,1.00,0.50,0.25,0.10,0.05]
    
    for x in denom:
        if change >= x:
           qty = int(change/x)
           p = x*qty
           change = round(change-p, 2)
           print(format(x, '.2f'), "x" , qty, "=", format(p, '.2f'))
    print("------------------\n          ", round(initialChange,2))
    
process()