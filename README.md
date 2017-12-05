# identify-c-uses-2
# find all global c-uses in java file

the algorithm:
1. we use spoon to extract all the methods from java class
2. foreach method:
  2.1. find all the global variables in the given method (variables given in the input)
  2.2. find all the definitions in the given method (like a=7..)
  2.3. find all the computations in the method (like: a=b+1, b= b+1)
  2.4. for each computation we found in 2.3:
    2.4.1. put in dictionery: key: computation, value:list that contain all the varibels that related. (ex: if we have the computation: a= b+c => key:a=b+c, value:b,c)
  2.5. foreach defs
    2.5.1. check if their is match to c-use in respect to the current def varible (run on the values's dictionery we created and check if current def exist)
    2.5.2. if we found c-use for def- add the computation to ans
  2.6. foreach global varibles
    2.6.1. check if their is match to c-use in respect to the current varible
    2.6.2. if we found c-use for global varibles- add the computation to ans
   
      return ans
      
***important!!!  need to cahnge.. maybe add number to each def and computation and check if the def is before the computation- otherwise its not global c-use
