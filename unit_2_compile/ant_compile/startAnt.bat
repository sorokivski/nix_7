call ..\ant_compile\setant.bat

call ant clean
call ant compile
call ant jar
call ant run