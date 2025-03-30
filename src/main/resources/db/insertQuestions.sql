INSERT INTO question(
     category, difficulty_level, option1, option2, option3, option4, question_title, right_answer)
        VALUES 
        -- Java Questions
        ('Java','Easy','int','float','double','char','Which data type is used to store whole numbers?','int'),
        ('Java','Easy','System.out.println','print','echo','cout','Which statement is used to print in Java?','System.out.println'),
        ('Java','Easy','class','object','method','variable','What is an instance of a class called?','object'),
        ('Java','Easy','public','private','protected','default','Which access modifier allows access from anywhere?','public'),
        ('Java','Easy','int','Integer','float','String','Which data type is used to store text?','String'),
        ('Java','Medium','public','private','protected','default','Which access modifier allows access within the same package?','default'),
        ('Java','Medium','Overloading','Overriding','Inheritance','Polymorphism','What is it called when two methods have the same name but different parameters?','Overloading'),
        ('Java','Medium','JVM','JRE','JDK','JIT','Which component is responsible for executing Java bytecode?','JVM'),
        ('Java','Medium','StringBuilder','StringBuffer','String','StringTokenizer','Which class is mutable in Java?','StringBuilder'),
        ('Java','Medium','int','Integer','float','double','Which is a wrapper class for primitive int?','Integer'),
        ('Java','Hard','Heap','Stack','Method Area','Class Loader','Where are objects stored in memory in Java?','Heap'),
        ('Java','Hard','Checked Exception','Unchecked Exception','Error','Runtime Exception','Which type of exception must be handled explicitly?','Checked Exception'),
        ('Java','Hard','Abstract Class','Interface','Enum','Annotation','Which feature is used to achieve multiple inheritance in Java?','Interface'),
        ('Java','Hard','Garbage Collector','JVM','JIT','Compiler','Which component is responsible for memory management in Java?','Garbage Collector'),
        ('Java','Hard','synchronized','volatile','transient','final','Which keyword is used to prevent thread interference?','synchronized'),

        -- Python Questions
        ('Python','Easy','list','tuple','dictionary','set','Which data structure is ordered and mutable?','list'),
        ('Python','Easy','def','class','lambda','return','Which keyword is used to define a function in Python?','def'),
        ('Python','Easy','True','False','None','0','What is the boolean value for "yes" in Python?','True'),
        ('Python','Easy','for','while','do-while','foreach','Which loop is used to iterate over a sequence in Python?','for'),
        ('Python','Easy','len()','size()','count()','length()','Which function is used to get the length of a list in Python?','len()'),
        ('Python','Medium','list','tuple','dictionary','set','Which data structure is unordered and mutable?','set'),
        ('Python','Medium','__init__','__str__','__repr__','__del__','Which method is called a constructor in Python?','__init__'),
        ('Python','Medium','lambda','def','map','filter','Which keyword is used to create anonymous functions?','lambda'),
        ('Python','Medium','is','==','!=','in','Which operator checks for object identity?','is'),
        ('Python','Medium','pip','conda','virtualenv','wheel','Which tool is used to install Python packages?','pip'),
        ('Python','Hard','O(1)','O(n)','O(log n)','O(n^2)','What is the time complexity of searching in a dictionary?','O(1)'),
        ('Python','Hard','try','except','finally','raise','Which block is always executed in exception handling?','finally'),
        ('Python','Hard','Decorator','Generator','Iterator','Context Manager','Which feature is used to modify the behavior of a function?','Decorator'),
        ('Python','Hard','__name__','__main__','__file__','__init__','Which variable is used to check if a script is run directly?','__name__'),
        ('Python','Hard','list comprehension','generator expression','lambda function','map function','Which feature is used for memory-efficient iteration?','generator expression');
