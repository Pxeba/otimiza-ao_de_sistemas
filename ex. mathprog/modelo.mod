/* decision variables */
var x1 >=0;  
var x2 >=0;  
var x3 >=0;  
var x4 >=0;  
var x5 >=0;  
var x6 >=0;  
var x7 >=0;  
var x8 >=0;  
var x9 >=0;  
var x10 >=0;  

/* objective function */
minimize z: x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9 + x10;

/* Constraints */
c1: x2 + x3 + x4 >= 22;
c2: x6 + x7 + x8 >= 25;
c3: x5 >= 12;
c4: x9 + 2*x10 >= 14;
c5: 3*x1 + x5 >= 18;
c6: x6 + x9 >= 18;
c7: x2 + x7 + x8 >= 20;
c8: x9 >= 10;
c9: x3 >= 12;
c10: 2*x4 >= 14;
c11: x8 >= 16;
c12: x2 + x3 + x7 + x10 >= 18;
c13: x5 + x6 >= 20;

end;
