@echo on

SET mypath=%~dp0

echo %mypath% 

call mvn clean -f %mypath%pom.xml

call mvn install -f %mypath%pom.xml