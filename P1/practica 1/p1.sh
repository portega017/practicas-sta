




#!/bin/bash

fich="alumnos.csv"
opcion=$1


cont=0 #contador que recorrerá el array a 0

while IFS= read line #abrir el fichero fich en modo lectura
do
#echo "$line" #imprimir por pantalla el fichero, línea a línea
    arrayCol=(${line//,/ });
    a1=(${arrayCol[0]});
    a2=(${arrayCol[1]});
    n=(${arrayCol[2],,});
    

identificador="${n}.${a1}.${a2}"

if [ $cont != 0 ]; then
    echo -e ${identificador}
fi
cont=cont+1
done< $fich  #cerrar el fichero fich



