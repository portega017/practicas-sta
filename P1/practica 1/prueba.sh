#!/bin/bash

fich="alumnos.csv"
opcion=$1
if [ "$opcion" = "alta" ]; then
	sudo groupadd sta #crear el grupo sta en el equipo
fi

cont=0 #contador que recorrerá el array a 0

while IFS= read line #abrir el fichero fich en modo lectura
do
#echo "$line" #imprimir por pantalla el fichero, línea a línea
    arrayCol=(${line//,/ });
    a1=(${arrayCol[0],,});
    a2=(${arrayCol[1],,});
    n=(${arrayCol[2],,});

identificador="${n}.${a1}.${a2}"

if [ $cont != 0 ]; then
    echo -e ${identificador}
    if [ "$opcion" = "alta" ]; then
        sudo useradd -m $identificador -g sta -N #crear usuario y carpeta de usuario
       # sudo usermod -a -G sta $identificador #añadir el usuario al grupo STA
    elif [ "$opcion" = "baja" ]; then
      #  sudo deluser sta $identificador
        sudo userdel  $identificador
        sudo rm -r /home/$identificador
    fi

fi
cont=cont+1
done< $fich  #cerrar el fichero fich

if [ "$opcion" = "baja" ]; then
        sudo groupdel sta #borrar el grupo sta del equipo
fi

