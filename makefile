# This variable holds the path to where the junit files are
# located
JUnitLibs=./junit/hamcrest-core-1.3.jar:./junit/junit-4.12.jar

# This variable holds the location of the test files, which
# in this case is the current directory
TestLocation=classes


full: #Compile and run
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

test:
	make build_tests
	make run_tests




install_junit:
	# Downloads the junit.zip file from the course web
	curl http://wrigstad.com/ioopm18/misc/junit.zip -o junit/junit.zip
	# Unzip the file into the directory junit
	unzip junit/junit.zip -d junit
	# Remove the junit.zip file
	rm -f junit/junit.zip
