# This variable holds the path to where the junit files are
# located
JUnitLibs=./junit/hamcrest-core-1.3.jar:./junit/junit-4.12.jar

# This variable holds the location of the test files, which
# in this case is the current directory
TestLocation=classes


full:		# Compile and run
	make compile
	make run
compile: #compile code to ./classes
	javac  -d ./classes GameOfLife.java Cell.java Board.java
run:  #run Main file
	cd ./classes/ && java GameOfLife
clean: #Remove all classes
	cd classes/ && rm *.class

build_tests:
	javac -cp classes:${JUnitLibs} -d classes Tests.java

run_tests:
	java -cp classes:${JUnitLibs} junit.textui.TestRunner Tests

tests:
	make compile
	make build_tests
	make run_tests
