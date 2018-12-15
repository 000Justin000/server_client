all:
	mkdir bin -p
	javac src/server_client/*.java -d bin

runserver:
	java -cp bin server_client.Server

runclient:
	java -cp bin server_client.Client

clean:
	rm -rf bin
