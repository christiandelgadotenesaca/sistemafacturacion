/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author USUARIO
 */
public class cls_validacion {
    
    public String cls_validar(String cedula) {
    String R=""; //Variable donde almacenará si la cédula/RUC es correcta(o)
    int multiplicador [] = {2,1,2,1,2,1,2,1,2};
    int longitud= cedula.length(), aux=0, suma=0; //variable.length() extrae la longitud de la cadena
    switch (longitud) 
        {
        case 10://comprueba si es un numero de cedula
            //inicia comprobacion de numero de cedula
            int dos_primeros = Integer.parseInt(cedula.substring(0, 2));//extrae los dos primeros numeros de la cedula
            if ((dos_primeros>0)&&(dos_primeros<25)) 
            {
                int tercero = Integer.parseInt(cedula.substring(2,3));//extrae tercer digito del numero
                if ((tercero>=0) && (tercero<7)) //condicion que el tercer numero sea menor a 7
                {
                    for (int i=0;i<9;i++)//inicia bucle de multiplicacion
                    {
                        aux= multiplicador[i]*Integer.parseInt(cedula.substring(i,i+1));//multiplica cada digito con su respectivo numero del vector multiplicador
                        if (aux>9)//condicion que el resultado no sea mayor a 9
                        {
                            aux -=9;//si el resultado es mayor a 9 se le debe restar 9
                        }
                        suma= suma+aux;//suma los resultados de cada multiplicacion
                    }  
                    int decena = (Integer.parseInt((""+suma).substring(0,1))+1)*10;//extrae primer digito del numero; lo suma 1 y lo multiplica por 10 para obtener la siguiente decena 
                    int respuesta= decena - suma;
                    if (respuesta != Integer.parseInt(cedula.substring(9, 10)))//comprueba si el resultado de las operaciones no coincide con el digito verificador
                    { 
                        R="Numero de cedula incorrecto (no coincide digito verificador de la cedula)"; //no coincide digito verificador de la cedula
                    } 
                }
                else
                {
                    R="Numero de cedula incorrecto (tercer numero fuera de rango [0,6])"; //tercer numero incorrecto
                }
            }
            else
            {
                R="Numero de cedula incorrecto (dos primeros numeros fuera de rango [1,24])"; //dos primeros incorrectos
            }
            break;//fin de comprobacion de cedula
        case 13://comprueba si es un numero de RUC
            String tres_primeros = cedula.substring(0, 3);//extrae tres primeros digitos
            if("019".equals(tres_primeros))
            {//inicia comprobacion de RUC privado
                String tres_ultimos = cedula.substring(10, 13);
                if("001".equals(tres_ultimos)) // condicion si el RUC termina en 001
                {
                    multiplicador[0]=4;//vector de comprobacion
                    multiplicador[1]=3;
                    multiplicador[2]=2;
                    multiplicador[3]=7;
                    multiplicador[4]=6;
                    multiplicador[5]=5;
                    multiplicador[6]=4;
                    multiplicador[7]=3;
                    multiplicador[8]=2;
                    for (int i=0;i<9;i++)//inicia bucle de multiplicaciones
                    {
                        suma += (multiplicador[i]*Integer.parseInt(cedula.substring(i,i+1))); //multiplica cada digito con su respectivo numero del vector $multiplicador y suma cada resultado
                    }
                    suma = 11- (suma%11);//% extrae el residuo de una division
                    if(suma!=Integer.parseInt(cedula.substring(9,10)))//comprueba si el resultado de las operaciones es igual al décimo digito
                    {
                        R="Numero de RUC incorrecto";//no coincide digito verificador
                    }
                }
                else
                {
                    R="Numero de RUC incorrecto (ultimos diferentes de 001)";
                }
                //fin comprobacion de RUC privado
            }
            else
            {
                if ("016".equals(tres_primeros))
                {//inicia comprobacion de RUC público
                    String cuatro_ultimos = cedula.substring(9,13);
                    System.out.print(cuatro_ultimos);//extrae 4 ultimos digitos del numero
                    if("0001".equals(cuatro_ultimos))//comprueba que termine en 0001
                    {
                        multiplicador[0]=3;//vector de comprobacion
                        multiplicador[1]=2;
                        multiplicador[2]=7;
                        multiplicador[3]=6;
                        multiplicador[4]=5;
                        multiplicador[5]=4;
                        multiplicador[6]=3;
                        multiplicador[7]=2;
                        for (int i=0;i<8;i++)//inicia bucle de multiplicaciones
                        {
                            suma += (multiplicador[i]*Integer.parseInt(cedula.substring(i,i+1))); //multiplica cada digito con su respectivo numero del vector $multiplicador y suma cada resultado
                        }
                        suma = 11- (suma%11);//% extrae el residuo de una division
                        if(suma!=Integer.parseInt(cedula.substring(8,9)))//comprueba si el resultado de las operaciones coincide con el digito verificador
                        {
                            R="Numero de RUC incorrecto";//no coincide digito verificador
                        }
                    }
                    else
                    {
                        R="Numero de RUC incorrecto (ultimos diferentes de 0001";//cuatro ultimos incorrectos
                    }
                    //fin comprobacion de RUC público
                }
                else
                {
                    String tres_ultimos = cedula.substring(10, 13);//extrae tres ultimos digitos del numero
                    if("001".equals(tres_ultimos)) // condicion si el RUC termina en 001
                    {//inicia comprobacion de cedula - RUC
                        dos_primeros = Integer.parseInt(cedula.substring(0, 2));//extrae los dos primeros numeros de la cedula
                        if ((dos_primeros>0)&&(dos_primeros<25)) 
                        {
                            int tercero = Integer.parseInt(cedula.substring(2,3));//extrae tercer digito del numero
                            if ((tercero>=0) && (tercero<7)) //condicion que el tercer numero sea menor a 7
                            {
                                for (int i=0;i<9;i++)//inicia bucle de multiplicacion
                                {
                                    aux= multiplicador[i]*Integer.parseInt(cedula.substring(i,i+1));//multiplica cada digito con su respectivo numero del vector multiplicador
                                    if (aux>9)//condicion que el resultado no sea mayor a 9
                                    {
                                        aux -=9;//si el resultado es mayor a 9 se le debe restar 9
                                    }
                                    suma= suma+aux;//suma los resultados de cada multiplicacion
                                }  
                                int decena = (Integer.parseInt((""+suma).substring(0,1))+1)*10;//extrae primer digito del numero; lo suma 1 y lo multiplica por 10 para obtener la siguiente decena 
                                int respuesta= decena - suma;
                                if (respuesta != Integer.parseInt(cedula.substring(9, 10)))//comprueba si el resultado de las operaciones coincide con el digito verificador
                                {
                                    R="Numero de RUC incorrecto (no coincide digito verificador de cedula-RUC)"; //no coincide digito verificador de cedula-RUC
                                } 
                            }
                            else
                            {
                                R="Numero de RUC incorrecto (tercer numero fuera de rango [0,6])"; //tercer numero incorrecto
                            }
                        }
                        else
                        {
                            R="Numero de RUC incorrecto (dos primeros numeros fuera de rango [1,24])"; //dos primeros incorrectos
                        }
                        //fin comprobacion de cedula-RUC
                    }
                    else
                    {
                        R="Numero de RUC incorrecto (ultimos diferentes de 001)";
                    }
                }
            }
            break;
        default:
            R="Numero de cedula incorrecto(Cantidad de digitos erronea)";
            break;
        }
    return R;//Retorna el resultado
    }    
}
