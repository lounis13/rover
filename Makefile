
all: clean
	clear
	mvn package
	cp target/rover.jar .
	mvn clean
	clear
	echo '[info] generate rover.jar done'

clean:
	mvn clean
	rm -Rf rover.jar