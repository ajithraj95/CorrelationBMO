
SET mypath=%~dp0


for %%a in ("%mypath%") do set "p_dir=%%~dpa"
for %%a in (%p_dir:~0,-1%) do set "p_dir2=%%~dpa"

for %%a in ("%p_dir2%") do set "p_dir3=%%~dpa"
for %%a in (%p_dir3:~0,-1%) do set "parent_dir=%%~dpa"

cd %parent_dir%apache-tomcat-9.0.64\bin


start shutdown.bat

move nul 2>&0