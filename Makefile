all:
	sbt "run --backend v"

clean:
	rm -rf *.h *.cpp *.v
