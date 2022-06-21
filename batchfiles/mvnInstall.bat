@echo on

SET mypath=%~dp0

for %%a in ("%mypath%") do set "p_dir=%%~dpa"
for %%a in (%p_dir:~0,-1%) do set "parent_dir=%%~dpa"

cd %parent_dir

call mvn clean -f %mypath%pom.xml

call mvn install -f %mypath%pom.xml

