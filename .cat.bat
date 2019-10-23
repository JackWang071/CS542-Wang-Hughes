@echo off
::get current directory path and assign to var
set var=%cd%
::wipe old output.txt file
ECHO|set /p= "" > output.txt
::copy file name and contents into output.txt (exclude this batch file and output)
for %%a in (*) do if not "%%a"=="output.txt" if not "%%a"==".cat.bat"  (echo %%a >> output.txt & type @echo %%a >> output.txt & echo. >> output.txt & echo. >> output.txt)
::its 4am and im too tired to format this nicer
::PAUSE