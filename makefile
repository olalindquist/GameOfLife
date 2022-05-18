full: #Compile and run
	make compile
	make run
compile: #compile code to ./classes
	javac *.java -d ./classes
run:  #run Main file
	cd ./classes/ && java GameOfLife
clean: #Remove all classes
	cd classes/ && rm *.class
