from PIL import Image
import imagehash
import mysql.connector

mydb = mysql.connector.connect(host="localhost", user="root", passwd="1234",database="pracdb")
mycursor = mydb.cursor()
mycursor.execute("select * from citizens")

def getAadhar(oh):
	return int(oh.split('.')[0])

x=[]
y=[]
#k=0
for i in mycursor:

	

	hash = imagehash.average_hash(Image.open(i[3]))
	x.append(getAadhar(i[3]))

	for j in mycursor:

		otherhash = imagehash.average_hash(Image.open(j[3]))

		if((hash-otherhash)<12.5 and (hash-otherhash)!=0 ):
			x.append(getAadhar(j[3]))

	if(len(x)>1	):
		y.append(x)

	x=[]

for i in y:
	print(i)

fp=open("Frauds.txt",'w')
for i in y:
	for k in i:
		fp.write(str(k))
		fp.write('\n')