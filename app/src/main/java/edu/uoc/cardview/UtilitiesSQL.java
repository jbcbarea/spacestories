package edu.uoc.cardview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.uoc.cardview.modelos.CuentosContenido;
import edu.uoc.cardview.modelos.CuentosRV;

import static edu.uoc.cardview.MainActivity.cuentosRVArrayList;

public class UtilitiesSQL {

    String pruebaContenidoIngles;

    public static ArrayList<CuentosContenido> pruebaContenido = new ArrayList<>();
    public void consultFromSQLiteListCuentos(ConexionSQLite sq,String query) {

        SQLiteDatabase db = sq.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cuentosRVArrayList.removeAll(cuentosRVArrayList);
        while (cursor.moveToNext()) {

            System.out.println(cursor.getCount());
            //  int id = cursor.getInt(0);
            CuentosRV cRV = new CuentosRV();
            //CuentosRV cRV = new CuentosRV(imgCuentos[cursor.getInt(1)],cursor.getString(0));
            int idImage = cursor.getInt(1);
            String title = cursor.getString(0);
            int Id = cursor.getInt(2);
            cRV.setTitle(title);
            cRV.setImage(idImage);
            cRV.setId(Id);
            cuentosRVArrayList.add(cRV);
            System.out.println("A ver como salen los cuentos ...." + "---------------" + idImage + "---------------------" + title);
        }

        //Log.i("CONTACTos", "Array de la base de datos" + misCumpl.toString());
        cursor.close();
        db.close();
    }

    public void insertCuentos(ConexionSQLite sq) {

        SQLiteDatabase db = sq.getWritableDatabase();
        String sqlBueno;
        String sql = "INSERT INTO CUENTOS VALUES(1,0,'CUENTO DE SIMBAD EL MARINO');" +
                "INSERT INTO CUENTOS VALUES(2,1,'CUENTO LOS MÚSICOS DE BREMEN');" +
                "INSERT INTO CUENTOS VALUES(3,2,'CUENTO DE LA LEYENDA GUILLERMO TELL');" +
                "INSERT INTO CUENTOS VALUES(4,3,'CUENTO DE EL FLAUTISTA DE HAMELÍN');" +
                "INSERT INTO CUENTOS VALUES(5,4,'CUENTO LOS VIAJES DE GULIVER');" +
                "INSERT INTO CUENTOS VALUES(6,5,'CUENTO DE RICITOS DE ORO Y LOS TRES CERDITOS');" +
                "INSERT INTO CUENTOS VALUES(7,6,'CUENTO DE PULGARCITO');" +
                "INSERT INTO CUENTOS VALUES(8,7,'CUENTO DE LOS SIETE CABRITILLOS');" +
                "INSERT INTO CUENTOS VALUES(9,8,'CUENTO DE LAS ZAPATILLAS ROJAS');" +
                "INSERT INTO CUENTOS VALUES(10,9,'CUENTO DE EL GATO CON BOTAS');" +
                "INSERT INTO CUENTOS VALUES(11,10,'CUENTO DE BLANCANIEVES Y LOS SIETE ENANITOS');" +
                "INSERT INTO CUENTOS VALUES(12,11,'CUENTO DE BAMBI');" +
                "INSERT INTO CUENTOS VALUES(13,12,'CUENTO DE PEDRO Y EL LOBO');" +
                "INSERT INTO CUENTOS VALUES(14,13,'CUENTO DE ALADINO Y LA LÁMPARA MARAVILLOSA');" +
                "INSERT INTO CUENTOS VALUES(15,14,'CUENTO DE PINOCHO');" +
                "INSERT INTO CUENTOS VALUES(16,15,'CUENTO DE LA CENICIENTA');" +
                "INSERT INTO CUENTOS VALUES(17,16,'FÁBULA DE LA LIEBRE Y LA TORTUGA');" +
                "INSERT INTO CUENTOS VALUES(18,17,'FÁBULA DE LA CIGARRA Y LA HORMIGA');" +
                "INSERT INTO CUENTOS VALUES(19,18,'CUENTO DE EL MAGO DE OZ');" +
                "INSERT INTO CUENTOS VALUES(20,19,'CUENTO DE GARBANCITO');" +
                "INSERT INTO CUENTOS VALUES(21,20,'CENICIENTO Y LAS ZAPATILLAS MÁGICAS');" +
                "INSERT INTO CUENTOS VALUES(22,21,'LA VIDA SECRETA DE LOS OBJETOS');" +
                "INSERT INTO CUENTOS VALUES(23,22,'CUENTO DE LA CIUDAD SIN COLORES');" +
                "INSERT INTO CUENTOS VALUES(24,23,'CUENTO DE EL NIÑO DAVID Y LA BALLENA');" +
                "INSERT INTO CUENTOS VALUES(25,24,'CUENTO DE EL DESVÁN DE LA ABUELA');" +
                "INSERT INTO CUENTOS VALUES(26,25,'10 CUENTOS PARA DORMIR FELICES');" +
                "INSERT INTO CUENTOS VALUES(27,26,'5 CUENTOS DE PRINCESAS PARA LEER Y DORMIR');" +
                "INSERT INTO CUENTOS VALUES(28,27,'PULGARCITA CONOCE EL MUNDO');" +
                "INSERT INTO CUENTOS VALUES(29,28,'EL PARAGUAS ROJO DE ESTÍBALIZ');" +
                "INSERT INTO CUENTOS VALUES(30,29,'CUENTO DE EL GATO SOÑADOR');" +
                "INSERT INTO CUENTOS VALUES(31,30,'CUENTO DE LA FAROLA DORMILONA');" +
                "INSERT INTO CUENTOS VALUES(32,31,'CUENTO DE EL RELOJ DORADO');" +
                "INSERT INTO CUENTOS VALUES(33,32,'CUENTO DE LOS TRES CERDITOS');" +
                "INSERT INTO CUENTOS VALUES(34,33,'The Ugly Duckling');" +
                "INSERT INTO CUENTOS VALUES(35,34,'CUENTO DE EL GUSANO QUE QUERÍA SER MARIPOSA DE SEDA');" +
                "INSERT INTO CUENTOS VALUES(36,35,'CUENTO LA RATITA PRESUMIDA');" +
                "INSERT INTO CUENTOS VALUES(37,36,'CUENTO DE EL CONEJO GRUÑON');" +
                "INSERT INTO CUENTOS VALUES(38,37,'The Princess and the Pea');" +
                "INSERT INTO CUENTOS VALUES(39,38,'Snow White');" +
                "INSERT INTO CUENTOS VALUES(40,39,'The Little Mermaid');" +
                "INSERT INTO CUENTOS VALUES(41,40,'Rapunzel');" +
                "INSERT INTO CUENTOS VALUES(42,41,'The Velveteen Rabbit');" +
                "INSERT INTO CUENTOS VALUES(43,42,'The Little Old Woman Who Lived in a Shoe');" +
                "INSERT INTO CUENTOS VALUES(44,43,'Twas The Night Before Christmas');" +
                "INSERT INTO CUENTOS VALUES(45,44,'A Letter from Santa Claus');" +
                "INSERT INTO CUENTOS VALUES(46,45,'10 CUENTOS EN INGLÉS PARA NIÑOS');" +
                "INSERT INTO CUENTOS VALUES(47,46,'ELEPHANT AMARANTA FEAR');" +
                "INSERT INTO CUENTOS VALUES(48,47,'NOELIA WANTS AN OMELETTE');" +
                "INSERT INTO CUENTOS VALUES(49,48,'THE SLEEPY LAMPPOST');" +
                "INSERT INTO CUENTOS VALUES(50,49,'THE BUNNY WITHOUT EARS');" +
                "INSERT INTO CUENTOS VALUES(51,51,'THE VILLAIN OF THE STORY');" +
                "INSERT INTO CUENTOS VALUES(52,52,'LEYENDAS URBANAS CORTAS PARA UNA NOCHE DE MIEDO');" +
                "INSERT INTO CUENTOS VALUES(53,53,'EL HUESO CANTOR');" +
                "INSERT INTO CUENTOS VALUES(54,54,'CUENTO DE JACK-O-LANTERN Y LAS CALABAZAS DE HALLOWEEN');" +
                "INSERT INTO CUENTOS VALUES(55,55,'CUENTO DE JUAN SIN MIEDO');" +
                "INSERT INTO CUENTOS VALUES(56,56,'CUENTO DE CIENTIFICO LOCO PARA NIÑOS');" +
                "INSERT INTO CUENTOS VALUES(57,57,'CUENTO DE CAPERUCITA ROJA');" +
                "INSERT INTO CUENTOS VALUES(58,58,'CUENTO DE PETER PAN');" +
                "INSERT INTO CUENTOS VALUES(59,59,'CUENTO DE HANSEL Y GRETEL');" +
                "INSERT INTO CUENTOS VALUES(60,60,'CUENTO DE SOPA DE LETRAS');" +
                "INSERT INTO CUENTOS VALUES(61,61,'CUENTO DE LA NIÑA QUE NO SABÍA REIR');" +
                "INSERT INTO TIPOCUENTO VALUES(1,'CLASICOS',1);" +
                "INSERT INTO TIPOCUENTO VALUES(2,'CLASICOS',2);" +
                "INSERT INTO TIPOCUENTO VALUES(3,'CLASICOS',3);" +
                "INSERT INTO TIPOCUENTO VALUES(4,'CLASICOS',4);" +
                "INSERT INTO TIPOCUENTO VALUES(5,'CLASICOS',5);" +
                "INSERT INTO TIPOCUENTO VALUES(6,'CLASICOS',6);" +
                "INSERT INTO TIPOCUENTO VALUES(7,'CLASICOS',7);" +
                "INSERT INTO TIPOCUENTO VALUES(8,'CLASICOS',8);" +
                "INSERT INTO TIPOCUENTO VALUES(9,'CLASICOS',9);" +
                "INSERT INTO TIPOCUENTO VALUES(10,'CLASICOS',10);" +
                "INSERT INTO TIPOCUENTO VALUES(11,'CLASICOS',11);" +
                "INSERT INTO TIPOCUENTO VALUES(12,'CLASICOS',12);" +
                "INSERT INTO TIPOCUENTO VALUES(13,'CLASICOS',13);" +
                "INSERT INTO TIPOCUENTO VALUES(14,'CLASICOS',14);" +
                "INSERT INTO TIPOCUENTO VALUES(15,'CLASICOS',15);" +
                "INSERT INTO TIPOCUENTO VALUES(16,'CLASICOS',16);" +
                "INSERT INTO TIPOCUENTO VALUES(12,'ANIMALES',17);" +
                "INSERT INTO TIPOCUENTO VALUES(17,'CORTOS',18);" +
                "INSERT INTO TIPOCUENTO VALUES(18,'CORTOS',19);" +
                "INSERT INTO TIPOCUENTO VALUES(19,'CORTOS',20);" +
                "INSERT INTO TIPOCUENTO VALUES(20,'CORTOS',21);" +
                "INSERT INTO TIPOCUENTO VALUES(21,'CORTOS',22);" +
                "INSERT INTO TIPOCUENTO VALUES(22,'CORTOS',23);" +
                "INSERT INTO TIPOCUENTO VALUES(23,'CORTOS',24);" +
                "INSERT INTO TIPOCUENTO VALUES(24,'CORTOS',25);" +
                "INSERT INTO TIPOCUENTO VALUES(25,'CORTOS',26);" +
                "INSERT INTO TIPOCUENTO VALUES(63,'CORTOS',27);" +
                "INSERT INTO TIPOCUENTO VALUES(64,'CORTOS',28);" +
                "INSERT INTO TIPOCUENTO VALUES(26,'DORMIR',29);" +
                "INSERT INTO TIPOCUENTO VALUES(27,'DORMIR',30);" +
                "INSERT INTO TIPOCUENTO VALUES(28,'DORMIR',31);" +
                "INSERT INTO TIPOCUENTO VALUES(29,'DORMIR',32);" +
                "INSERT INTO TIPOCUENTO VALUES(30,'DORMIR',33);" +
                "INSERT INTO TIPOCUENTO VALUES(31,'DORMIR',34);" +
                "INSERT INTO TIPOCUENTO VALUES(32,'DORMIR',35);" +
                "INSERT INTO TIPOCUENTO VALUES(60,'CLASICOS',36);" +
                "INSERT INTO TIPOCUENTO VALUES(61,'CLASICOS',37);" +
                "INSERT INTO TIPOCUENTO VALUES(62,'CLASICOS',38);" +
                "INSERT INTO TIPOCUENTO VALUES(33,'ANIMALES',39);" +
                "INSERT INTO TIPOCUENTO VALUES(34,'ANIMALES',40);" +
                "INSERT INTO TIPOCUENTO VALUES(35,'ANIMALES',41);" +
                "INSERT INTO TIPOCUENTO VALUES(36,'ANIMALES',42);" +
                "INSERT INTO TIPOCUENTO VALUES(37,'ANIMALES',43);" +
                "INSERT INTO TIPOCUENTO VALUES(38,'ANIMALES',44);" +
                "INSERT INTO TIPOCUENTO VALUES(8,'ANIMALES',49);" +
                "INSERT INTO TIPOCUENTO VALUES(2,'ANIMALES',45);" +
                "INSERT INTO TIPOCUENTO VALUES(10,'ANIMALES',46);" +
                "INSERT INTO TIPOCUENTO VALUES(17,'ANIMALES',47);" +
                "INSERT INTO TIPOCUENTO VALUES(18,'ANIMALES',48);" +
                "INSERT INTO TIPOCUENTO VALUES(27,'PRINCESAS',50);" +
                "INSERT INTO TIPOCUENTO VALUES(11,'PRINCESAS',51);" +
                "INSERT INTO TIPOCUENTO VALUES(39,'PRINCESAS',52);" +
                "INSERT INTO TIPOCUENTO VALUES(40,'PRINCESAS',53);" +
                "INSERT INTO TIPOCUENTO VALUES(41,'PRINCESAS',54);" +
                "INSERT INTO TIPOCUENTO VALUES(42,'PRINCESAS',55);" +
                "INSERT INTO TIPOCUENTO VALUES(43,'PRINCESAS',56);" +
                "INSERT INTO TIPOCUENTO VALUES(44,'NAV',57);" +
                "INSERT INTO TIPOCUENTO VALUES(45,'NAV',58);" +
                "INSERT INTO TIPOCUENTO VALUES(46,'NAV',59);" +
                "INSERT INTO TIPOCUENTO VALUES(47,'NAV',60);" +
                "INSERT INTO TIPOCUENTO VALUES(48,'NAV',61);" +
                "INSERT INTO TIPOCUENTO VALUES(49,'ING',62);" +
                "INSERT INTO TIPOCUENTO VALUES(50,'ING',63);" +
                "INSERT INTO TIPOCUENTO VALUES(51,'ING',64);" +
                "INSERT INTO TIPOCUENTO VALUES(52,'ING',65);" +
                "INSERT INTO TIPOCUENTO VALUES(53,'ING',66);" +
                "INSERT INTO TIPOCUENTO VALUES(54,'ING',67);" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(1,1,'El cuento de Simbad se volvió tan popular que hasta el cine adaptó su historia en varias ocasiones y por supuesto es uno de los relatos con moraleja más utilizados a la hora de querer enseñar acerca del valor del esfuerzo y el trabajo para obtener éxitos en la vida...','Érase una vez un muchacho llamado Simbad que decidió embarcarse en un barco para comerciar por el mundo.\n" +
                "\n" +
                "Un día el viento dejó de soplar y el barco se paró muy cerca de una isla. Simbad y otros tripulantes del barco decidieron ir a visitar la isla. Estando en la isla tuvieron hambre, así que encendieron una hoguera para asar carne. De repente, el suelo se estremeció como si de un terremoto se tratase.\n" +
                "\n" +
                "Lo que pasaba es que no habían desembarcado en una isla, sino en el lomo de una enorme ballena que, al sentir el fuego, empezó a dar coletazos. En una de estas embestidas Simbad cayó al agua. Los tripulantes del barco pensaron que se había ahogado, así que se fueron nadando al barco y huyeron.\n" +
                "\n" +
                "Pero Simbad consiguió agarrarse a una madera que flotaba por allí hasta que una ola lo arrojó sobre una playa.\n" +
                "\n" +
                "-¿Qué será esto? -exclamó Simbad al ver unas bolas blancas de gran tamaño.\n" +
                "\n" +
                "De pronto, Simbad miró hacia arriba y vio a un inmenso pájaro que iba hacia él.\n" +
                "\n" +
                "-¡Es el pájaro Roc! -gritó asustado.\n" +
                "\n" +
                "Pero no le dio tiempo a más. El pájaro Roc se posó sobre él para calentar las bolas blancas, que eran sus huevos.\n" +
                "\n" +
                "Simbad aprovechó para pensar cómo salir e ideó un plan.\n" +
                "\n" +
                "- Enrollaré mi turbante a la pata del pájaro Roc para que me lleve volando por la mañana -pensó Simbad.\n" +
                "\n" +
                "Y así fue. Al amanecer, el pájaro se echó a volar, llevándose a Simbad con él hasta otro lugar en el que se posó.\n" +
                "\n" +
                "Simbad descubrió que estaba en un profundo valle, rodeado de montañas tan altas que era imposible escalarlas. Cuando se sentó a descansar y a pensar en la falda de una de las montañas descubrió que estaba rodeado de serpientes.\n" +
                "\n" +
                "-¡Qué mala suerte! -dijo Simbad-. ¡Consigo escapar de un problema para meterme en otro peor!\n" +
                "\n" +
                "Entonces Simbad se dio cuenta de que aquel misterioso valle también estaba lleno de preciosos diamantes.\n" +
                "\n" +
                "-¡Aquí estoy, rodeado de la mayor fortuna del mundo y condenado a no salir jamás! -se lamentó Simbad.\n" +
                "\n" +
                "Sin embargo, por si acaso, Simbad llenó un saquito de cuero que llevaba encima con diamantes. Mientras metía los diamantes en la bolsa tuvo una idea:\n" +
                "\n" +
                "-Mataré a una serpiente y me ataré a ella con el turbante. Luego esperaré a que venga el pájaro Roc a comérsela. Entonces me iré con él.\n" +
                "\n" +
                "Y así ocurrió. Durante el viaje, el pájaro Roc sobrevoló el mar. Simbad divisó un enorme barco navegando sobre las aguas azules. Cortó con un cuchillo el turbante y cayó al agua, confiando en que los tripulantes del barco le rescataran.\n" +
                "\n" +
                "GSimbad, el marinoracias a los diamantes a Simbad nunca no le faltó de nada. Aún así, decidió volver a embarcarse. Pero, ya en alta mar, unos piratas asaltaron su barco y lo apresaron para venderlo como esclavo.\n" +
                "\n" +
                "-Pareces un hombre fuerte -dijo un mercader que quería comprarlo. -Dime qué hacer para ver si me puedes servir.\n" +
                "\n" +
                "-Manejo muy bien el arco -contestó Simbad.\n" +
                "\n" +
                "-Bien, demuéstramelo -dijo el mercader-. Ve a la selva y tráeme marfil de elefante.\n" +
                "\n" +
                "Pero a Simbad le daba mucha pena cazar elefantes y siempre fallaba los disparos. Un día vio un elefante muy viejo y lo siguió. Este le llevó hasta el cementerio de los elefantes. Allí había tantos colmillos que, cuando informó a su amo, éste se volvió loco de alegría.\n" +
                "\n" +
                "Para agradecer la fortuna que haría gracias a él, el hombre le dejó libre y le regaló un barco para que Simbad siguiese recorriendo los mares y viviendo grandes aventuras.');"+
                "INSERT INTO MisCONTENIDOCUENTOS VALUES (2,2,'Este cuento de los hermanos Grimm nos muestra por un lado el valor de la superación, a través del ejemplo de tres animales, que sabiéndose viejos para realizar sus antiguos trabajos no pierden la esperanza de volver a ser útiles y se embarcan en un viaje a Bremen. Por otro lado, el cuento nos habla del valor del trabajo en equipo, ya que gracias a ese trabajo conjunto y esa colaboración que realizan los cuatro animales, logran cumplir su objetivo de expulsar a los ladrones de la casa.','Había una vez un campesino que tenía un asno. Durante mucho tiempo le había servido para llevar los sacos de trigo al molino, pero el asno se empezó a hacer viejo e inservible y el amo pensó en deshacerse de él. El asno no era tonto, y como sabía de las intenciones de su amo se escapó rumbo a Bremen para tratar de hacer carrera como músico, ya que el animal tocaba el laúd.\n" +
                "\n" +
                "En su camino se tropezó con un perro cazador que jadeaba agotado.\n" +
                "\n" +
                "- ¿Todo bien amigo?\n" +
                "- Sí, sí tranquilo. Intentaba escaparme de mi amo, que quiere matarme porque soy viejo y ya no le sirvo para ir de caza.\n" +
                "- ¿Por qué no te vienes conmigo? Voy camino de Bremen, donde pienso ganarme la vida como músico. Juntos podríamos formar una banda… tu podrías tocar los timbales. ¿Qué te parece?\n" +
                "\n" +
                "El asno convenció al perro y continuaron su camino juntos. Al poco, se encontraron con un gato con mala cara.\n" +
                "\n" +
                "- ¿Qué te pasa minino? - preguntó el asno\n" +
                "- Que no tengo adónde ir. Mi ama ha tratado de ahogarme porque estoy viejo y me paso el día tirado junto al fuego.\n" +
                "- ¿Y por qué no te unes a nosotros? Vamos a Bremen, a formar una banda de música.\n" +
                "\n" +
                "El gato dijo que no sabía mucho de música, pero como no se le ocurría nada mejor aceptó y se unió al asno y al perro. Más adelante dieron con un gallo que gritaba con todas sus fuerzas.\n" +
                "\n" +
                "- ¿Por qué gritas gallo? - dijo el asno\n" +
                "- Porque mi ama va a echarme a la cazuela esta noche. Por eso grito mientras estoy vivo.\n" +
                "- Anda, no malgastes tu tiempo y vente con nosotros. Vamos a Bremen y tienes buena voz así que eres perfecto para nuestra banda de música.\n" +
                "\n" +
                "Continuaron caminando los cuatro animales todo lo que pudieron pero no llegaron esa misma noche a Bremen. No sabían dónde pasar la noche cuando vieron luz en una casa al otro lado del bosque y decidieron acercarse. Vieron a un grupo de ladrones a punto de darse un gran festín de comida y con el hambre que tenían decidieron que tenían que hacer algo para echar de la casa a los ladrones.\n" +
                "\n" +
                "El asno se colocó junto a la ventana, el perro se subió encima del asno, el gato encima del perro y el gallo encima de la cabeza del gato. Así, unos encima de otros, empezaron a rebuznar, ladrar, maullar y cantar con toda su alma. Rompieron incluso la ventana y armaron tal estruendo que los ladrones huyeron creyendo que se trataba de algún fantasma.\n" +
                "\n" +
                "Los animales cenaron hasta que ya no pudieron más y se echaron a dormir. El asno eligió el estiércol, el perro se fue detrás de la puerta, el gato prefirió las cenizas del hogar y el gallo se puso encima de una viga.\n" +
                "\n" +
                "A media noche uno de los ladrones, viendo a lo lejos que la casa parecía en calma se armó de valor y decidió volver.\n" +
                "\n" +
                "Los músicos de BremenPero cuando llegó la casa estaba a oscuras, confundió los ojos del gato con las brasas del hogar, acercó una cerilla y el gato le arañó la cara, fue hacia la puerta y le mordió el perro en la pierna, salió corriendo fuera de la casa, pisó el estercolero y el asno le dio una coz y justo en ese momento el gallo empezó a cantar desde la viga ¡¡Kirikíi!!\n" +
                "\n" +
                "El ladrón corrió todo lo rápido que pudieron sus pies y cuando llegó le contó a sus compañeros\n" +
                "- ¡En la casa hay una bruja que me ha arañado la cara, detrás de la puerta un hombre con un cuchillo que me lo ha clavado en la pierna, y fuera un monstruo que me ha golpeado con un terrible mazo!! Y encima del tejado un juez que gritaba ¡Traedme el ladrón aquí!\n" +
                "\n" +
                "Tras esto a los ladrones ni se les ocurrió volver a pisar esa casa y los músicos de Bremen todavía siguen allí.');"+
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(3,3,'Como hemos dicho, no existe evidencia histórica de la existencia real de Guillermo Tell. Es un personaje legendario de la independencia suiza, del siglo XIV. Ya en una serie de relatos legendarios de los siglos XV y XVI se incluye la narración de sus gestas, pero es evidente que hay mucho de imaginario en ellos. Lo más probable es que el personaje se haya inspirado en algún combatiente (o combatientes) por la independencia suiza no identificados de principios del siglo XIV, al cual la imaginación popular habría dotado posteriormente de elementos legendarios.\n" +
                "\n" +
                "Especialmente durante el Romanticismo, la figura de Tell encarnó ideales de lucha por la libertad y la justicia, y también el amor paterno. Por eso muchos autores de este periodo se inspiraron en su leyenda para componer óperas, obras de teatro y novelas.','Guillermo Tell era muy apreciado entre los habitantes de la población suiza de Altdorf, su ciudad natal. Era el mejor navegante en todo el lago de Lucerna, y el mejor arquero. Y odiaba al cruel duque Gessler, que había sido enviado por una potencia extranjera para gobernar y someter a aquella región.\n" +
                "\n" +
                "El valor y la destreza de Tell habían hecho de él un héroe a los ojos de sus paisanos. Por ese motivo, Gessler le odiaba y temía. De modo que Guillermo Tell, a fin de evitarse problemas, se fue a vivir a las montañas con su hijo, a quien quería más que a nadie en el mundo.\n" +
                "\n" +
                "En ocasiones, sin embargo, tenía que bajar a Altdorf en busca de provisiones. Un día, durante una de esas visitas, se quedó estupefacto al ver que todas las personas que cruzaban la plaza se inclinaban ante un palo alto coronado por un sombrero.\n" +
                "\n" +
                "—¿Qué pasa aquí? —preguntó.\n" +
                "\n" +
                "—El duque nos ha ordenado que hagamos una reverencia cada vez que pasemos frente a ese palo.\n" +
                "\n" +
                " \n" +
                "—¡Qué majadería! ¡Me niego a inclinarme ante un sombrero!— Y cruzó la plaza seguido de su hijo.\n" +
                "\n" +
                "—¡Deténte! —dijeron unos soldados, al tiempo que se abalanzaban sobre él.\n" +
                "\n" +
                "Una vez reducido, condujeron a Tell y a su hijo a la corte del duque. Gessler se frotó las manos de satisfacción y dijo:\n" +
                "\n" +
                "—Guillermo Tell, por el delito de desacato a mi sombrero, podría arrojarte a las mazmorras del castillo de Kussnacht para el resto de tus días.\n" +
                "\n" +
                "\n" +
                "Guillermo mantuvo erguida la cabeza y miró al duque con calma y serenidad.\n" +
                "\n" +
                " \n" +
                "Gessler se puso furioso. ¿Es que no había forma de desmoralizar a aquel hombre?\n" +
                "\n" +
                "«Sí», pensó sonriendo cínicamente, «tal vez sí exista un medio».\n" +
                "\n" +
                "—He oído decir que eres el mejor arquero del país —dijo, arrellanándose en su butaca.\n" +
                "\n" +
                "-¡Qh, sí, es cierto! —exclamó el hijo de Tell.\n" +
                "\n" +
                "—En tal caso sería una lástima que te pudrieras en la cárcel. Voy a hacerte la siguiente proposición: Si eres capaz de clavar tu flecha en una manzana a una distancia de cien pasos, te dejaré libre.\n" +
                "\n" +
                " \n" +
                "Guillermo no imaginaba por qué Gessler le brindaba la oportunidad de seguir libre. El tiro era ciertamente difícil, pero estaba seguro de conseguir partir la manzana y accedió. Con que se encaminaron a un campo donde crecía un joven roble. El duque, riendo, dijo: —Ahora, amarrad al chico al árbol y colocad sobre su cabeza una manzana. ¡Seguro que nuestro amigo se esmerará en no errar el tiro! Gessler sonrió satisfecho al ver palidecer a Tell. Había descubierto su punto débil: adoraba a su hijo. ¿Qué haría Tell? ¿Suplicaría ser encarcelado antes que poner en peligro la vida de su hijo? Guillermo notó que le temblaban las manos. Y si le temblaban al apuntar la flecha, ¿cómo podía arriesgar la vida de su hijo a cambio de conservar él la libertad?\n" +
                "\n" +
                "Entonces se oyó una voz que dijo:\n" +
                "\n" +
                "\n" +
                "—Tú puedes hacerlo, padre. Sé que puedes. No temas, no moveré un músculo hasta que hayas hecho diana en la manzana de mi cabeza.\n" +
                "\n" +
                "Los soldados amarraron al chico al árbol y colocaron una pequeña manzana roja sobre su cabeza. Guillermo montó una flecha en su ballesta.\n" +
                "\n" +
                "El niño permaneció inmóvil y vió cómo apuntaba el arco a su frente. Vio la punta metálica de la flecha reluciendo al sol. Contuvo la respiración. Sonó un ruido vibrante y la manzana cayó a sus pies en dos mitades. ¡Su padre había ganado la libertad!\n" +
                "\n" +
                "Gessler trató de disimular su ira. Entonces cayó una segunda flecha del forro de la chaqueta de Guillermo.\n" +
                "\n" +
                "—¿Por qué cogiste dos flechas?\n" +
                "\n" +
                "—De haber matado a mi hijo con la primera -respondió Guillermo sin alterarse—, habría clavado la segunda en tu despiadado corazón, Gessler.\n" +
                "\n" +
                "El duque, enfurecido, exclamó:\n" +
                "\n" +
                "—¡Morirás por tu traición! ¡Llevadle al castillo de Kussnacht al otro lado del lago y dejad que las bestias de la bodega lo devoren vivo!\n" +
                "\n" +
                "\n" +
                "Los soldados ataron a Guillermo y lo condujeron hasta el transbordador, rumbo a la siniestra fortaleza.\n" +
                "\n" +
                "-¡Vete a casa, hijo! —gritó Tell—. ¡Vete a casa y espérame!\n" +
                "\n" +
                "Cuando la embarcación alcanzo la parte más profunda del lago, se levantó un fuerte viento. El lago era una masa de olas gigantescas. La embarcación cabeceaba y se balanceaba. Los soldados estaban aterrados.\n" +
                "\n" +
                "-¡Sólo Guillermo Tell es capaz de dominar un barco con este temporal! —exclamó el capitán, mientras los demás gritaban: «¡Que nos salve Tell! ¡Que se haga cargo del barco!»\n" +
                "\n" +
                "Guillermo fue desatado y empuñó la caña del timón, haciendo girar la proa del barco en aquel torbellino de lluvia y espuma. Apenas si conseguía las rocas de la orilla que rasgaban el agua como afilados dientes.\n" +
                "\n" +
                "Giró el timón y una ola gigantesca levantó el barco y lo dejó caer sobre las rocas. ¡La quilla se partió en dos!\n" +
                "\n" +
                "Guillermo tomó la ballesta de un soldado, saltó sobre la proa, se agarró a las ramas de un árbol y alcanzó tierra firme. Los soldados extranjeros fueron engullidos por el lago.\n" +
                "\n" +
                "En la orilla opuesta se hallaba Gessler, observando horrorizado el trágico fin de sus mejores soldados. Hincando una rodilla en tierra, Guillermo apuntó la ballesta y disparó… clavando la flecha en el corazón de Gessler.\n" +
                "\n" +
                "\n" +
                "Luego, a través de la niebla, trepó por la ladera de la montaña hacia su casa, donde le esperaba su hijo.\n" +
                "\n" +
                "Al cabo de unos años, Suiza se libró del yugo extranjero y sus gentes recobraron la paz. Y todavía hoy se recuerda la gran hazaña del legendario Guillermo Tell.');\n" +

                "INSERT INTO MisCONTENIDOCUENTOS VALUES(4,4,'El cuento nos habla del valor de la honradez y la sinceridad a través de la mentira del alcalde. Nos explica lo negativo que es mentir a través de la horrible consecuencia que supone el engaño del alcalde al flautista y que supone el que los niños de Hamelín nunca regresen.','Hace mucho mucho tiempo hubo en Alemania una ciudad llamada Hamelín. Era una ciudad rodeada por murallas, muy bonita y también muy próspera puesto que tenía un importante puerto al que iban comerciantes de todo el mundo.\n" +
                "\n" +
                "Todos sus habitantes vivían felices en Hamelín hasta que un día, mientras todos dormían, empezaron a llegar a la ciudad cientos de ratas. Llegaron tantas que invadieron totalmente la ciudad hasta dejarla totalmente infectada. No había un lugar en el que no se encontrara una rata.\n" +
                "\n" +
                "La situación era tan terrible que el alcalde mandó traer gatos para que acabaran con ellos, trampas y ratoneras, pero no sirvió de nada. Incluso probaron con matarratas, pero no funcionaba. Las ratas eran cada vez más y más.\n" +
                "\n" +
                "En medio de esta situación llegó a Hamelín un trovador que aseguró al alcalde que sería capaz de limpiar la ciudad de ratas.\n" +
                "\n" +
                "- ¿Vos sólo podréis hacerlo?\n" +
                "\n" +
                "- Por supuesto. Pero a cambio pido mil monedas de oro.\n" +
                "\n" +
                "- No os preocupéis. Si lo conseguís os daré un millón si es necesario.\n" +
                "\n" +
                "El trovador llegó a la plaza del pueblo, sacó una flauta de madera de su bolsillo y empezó a tocar. En ese momento, las ratas comenzaron a salir de todos los rincones de la ciudad. Cientos y cientos se acercaron hasta él y comenzaron a seguirlo cuando empezó a recorrer todas las calles de Hamelín.\n" +
                "\n" +
                "El flautista continuó caminando hasta salir de la ciudad y llegar al río, donde se paró en la orilla y siguió tocando. Las ratas estaban tan ensimismadas por la música que cayeron al agua y murieron ahogadas.\n" +
                "\n" +
                "De modo que el flautista volvió a ver al alcalde para pedir su recompensa.\n" +
                "\n" +
                "El flautista de Hamelín- ¿Mil monedas de oro por una música? ¡Os daré como mucho cien monedas! - dijo el alcalde riéndose.\n" +
                "\n" +
                "- ¡Pero eso no es lo que me prometisteis! En ese caso lo lamentaréis.\n" +
                "\n" +
                "El trovador salió del ayuntamiento y comenzó a tocar con fuerza su flauta. En esta ocasión, fueron los niños, grandes y pequeños, los que empezaron a salir de las casas y comenzaron a seguirle allá donde iba.\n" +
                "\n" +
                "El flautista salió de la ciudad y todos los niños de Hamelín salieron con él y nunca más se los volvió a ver.');";


        sqlBueno =
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(7,7,'El personaje de Pulgarcito encarna en esta historia el valor del ingenio y la astucia ya que ante cualquier dificultad que se plantea busca siempre una solución y tiene la suerte de salir airoso.\n" +
                "Tal vez, en parte, y aquí estaría otro valor importante, porque a pesar de las dificultades no pierde la esperanza de regresar a casa con riquezas suficientes como para sacar a sus padres de la pobreza.\n" +
                "En último lugar, también, da un ejemplo de sacrificio cuando al final de la historia pide a sus hermanos que regresen a casa y en lugar de hacer él lo mismo, se arriesga para conseguir el objetivo propuesto.','Había una vez unos leñadores muy pobres que tenían siete hijos, todos ellos varones. El más joven de todos, que era también el más astuto, nació muy pequeño, del tamaño de un pulgar, y por eso todos le llamaban Pulgarcito.\n" +
                "\n" +
                "Una noche Pulgarcito oyó hablar a sus padres de la difícil situación en la que se encontraban ya que apenas ganaban lo suficiente para alimentar a sus siete hijos. Pulgarcito se entristeció mucho al oír a sus padres, pero rápidamente se puso a darle vueltas a la cabeza para encontrar una solución.\n" +
                "\n" +
                "A la mañana siguiente, reunió a sus hermanos en el pajar y les contó lo que había oído.\n" +
                "\n" +
                "- No os preocupéis, yo os diré lo que haremos.\n" +
                "- ¿Ah sí? ¿El qué? - dijo el mayor, que era un poco incrédulo\n" +
                "- El próximo día que vayamos al bosque a recoger leña con madre y padre nos esconderemos y cuando se harten de buscarnos y vuelvan a casa saldremos y emprenderemos un viaje en busca de riquezas y oro.\n" +
                "- Pero, ¿y si nos perdemos en el bosque? De noche está muy oscuro… - dijo el más miedoso\n" +
                "- No te preocupes. Iré dejando caer miguitas de pan a lo largo del camino así, cuando queramos volver a casa sólo tendremos que seguirlas.\n" +
                "\n" +
                "\n" +
                "La idea convenció a los siete y prometieron guardar el secreto.\n" +
                "\n" +
                "Esa misma tarde los padres les dijeron que necesitaban que les ayudaran a recoger ramas en el bosque. De modo que siguieron el plan establecido y cuando sus padres se cansaron de buscarlos y se fueron a casa, creyendo que habían vuelto allí, salieron de sus escondrijos.\n" +
                "\n" +
                "Pero la noche cayó antes de lo esperado y se levantó una tormenta tremenda. Algunos empezaron a impacientarse y decidieron que lo mejor era volver a casa. Pero… ¡qué sorpresa tan desagradable cuando Pulgarcito miró al suelo! Las migas no estaban. Sólo había un par por detrás de él y del resto nada. Se las habían tenido que comer los pájaros, no había otra explicación.\n" +
                "\n" +
                "Rápidamente Pulgarcito se subió a un árbol para tratar de divisar algún lugar al que dirigirse y logró distinguir una luz.\n" +
                "\n" +
                "- ¡Veo una casa! ¡Iremos por allí!\n" +
                "\n" +
                "Así que los niños continuaron andando durante horas hasta que lograron llegar a aquella casa. Estaban empapados y muertos de hambre. Una mujer les abrió la puerta.\n" +
                "\n" +
                "- Buena mujer, somos siete niños que se han perdido y no tenemos adónde ir. ¿Podría dejarnos pasar?\n" +
                "- Pero, ¿no sabéis quién vive aquí?\n" +
                "\n" +
                "Los niños negaron con la cabeza y la mujer les explicó que esa era la casa del ogro, su marido, y si los veía no se lo pensaría dos veces y los echaría a la cazuela. Pero los niños estaban tan exhaustos que no les importó y pidieron a la mujer que por favor les dejara pasar. Al final accedió, les dio de cenar y los escondió bajo la cama.\n" +
                "\n" +
                "En cuanto llegó el ogro a casa comenzó a gritar.\n" +
                "\n" +
                "- ¡¡Huelo a carne fresca!!\n" +
                "\n" +
                "Los niños estaban temblando bajo la cama rezando porque no mirase allí, pero el malvado ogro los encontró. Quiso comérselos en ese mismo instante pero su mujer logró convencerle de que lo dejara para el día siguiente ya que no había ninguna prisa y tenían comida de sobra.\n" +
                "\n" +
                "Se acostaron a dormir en la misma habitación en la que dormían las siete hijas de los ogros y Pulgarcito observó que cada una de las niñas llevaba una corona de oro en la cabeza.\n" +
                "\n" +
                "\n" +
                "Cuando todo el mundo dormía Pulgarcito tuvo una de sus ideas. No se fiaba de que el ogro cambiara de opinión y se los quisiera comer en mitad de la noche, así que por si acaso, les quitó a las niñas las coronas y las puso en las cabezas de sus hermanos y en la suya.\n" +
                "\n" +
                "Efectivamente Pulgarcito tuvo razón, y en mitad de la noche el ogro entró en la habitación.\n" +
                "\n" +
                "- A ver a quien tenemos por aquí… ¡Uy no, estas no! ¡Estas son mis hijas!\n" +
                "\n" +
                "Así que gracias a la corona el ogro se comió a sus hijas creyendo que eran Pulgarcito y sus hermanos.\n" +
                "\n" +
                "En cuanto salió de la habitación y lo oyó roncar, Pulgarcito despertó a sus hermanos y se marcharon de allí corriendo.\n" +
                "\n" +
                "A la mañana siguiente el ogro se dio cuenta del engaño y se puso sus botas de siete leguas para encontrarlos. Estuvo a punto de cogerlos, pero los niños lo oyeron llegar y se escondieron bajo una piedra. El ogro, acabó agotado de tanto correr en su búsqueda así que se sentó en el suelo y se quedó dormido. Salieron de su escondite y Pulgarcito ordenó a sus hermanos que volvieran a casa.\n" +
                "\n" +
                "Pulgarcito- No os preocupéis por mí. Me las apañaré para volver.\n" +
                "\n" +
                "Con mucho cuidado Pulgarcito le quitó las botas de siete leguas al ogro, se las calzó, y como eran unas botas mágicas que se adaptaban al pie de quien las llevara puestas, le quedaron perfectas. Con ellas se fue directo a casa del ogro.\n" +
                "\n" +
                "- Señora, vengo de parte del ogro. Me ha dejado las botas de siete leguas para que viniese lo antes posible y os pidiese auxilio. Unos ladrones lo han atrapado y dicen que lo matarán inmediatamente si no les dais todo el oro y plata que tengáis.\n" +
                "\n" +
                "La mujer se lo creyó todo y entregó a Pulgarcito todo el oro y plata que tenían. Cargado de riquezas volvió a casa y sus padres y hermanos lo recibieron con los brazos abiertos. Desde entonces ya nunca más volvieron a pasar necesidad.\n" +
                "\n" +
                "Aunque hay quien dice que la historia no acabó en realidad así, y afirman que Pulgarcito una vez tuvo las botas del ogro fue a hablar con el Rey. Pulgarcito había oído que el Rey estaba preocupado por su ejército, ya que se encontraba a muchas leguas de palacio y no había recibido ninguna noticia suya. Así que le propuso convertirse en su mensajero y llevarle tantos mensajes como necesitara. El Rey aceptó y Pulgarcito estuvo desempeñando durante un tiempo este oficio, tiempo en el que amasó una buena fortuna. Cuando hubo reunido suficiente volvió a casa de sus padres y todos juntos fueron muy felices.');\n" +
                "\n" +
                "\n" +
                "\n" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(8,8,'El cuento nos ejemplifica de una manera sencilla la importancia de la obediencia. Nos cuenta lo que les ocurre a los cabritillos por no haber obedecido a su madre y con ello apunta también a otros valores como son la prudencia y la responsabilidad. Esta historia sirve para hacer entender a los niños que deben ser prudentes con las personas que no conocen. Además les recuerda también las cosas que digan o hagan traen siempre una serie de consecuencias que deberán asumir, de ahí la importancia de obrar bien.','Había una vez una vieja cabra que tenía siete cabritillos. Los quería mucho y como no quería que les pasase nada malo, siempre insistía cuando se iba a por comida que tuvieran mucho cuidado y no abrieran la puerta a nadie.\n" +
                "\n" +
                "- No os fiéis de nadie. El lobo es muy astuto y es capaz de disfrazarse para engañaros. Si veis que tiene la voz ronca y la piel negra será él.\n" +
                "- ¡Síii mamá, tendremos cuidado!\n" +
                "\n" +
                "En cuanto la cabra desapareció, apareció el lobo y llamó a la puerta\n" +
                "\n" +
                "- ¿Quién es?, preguntaron los cabritillos\n" +
                "- Abridme hijos míos, soy vuestra madre.\n" +
                "\n" +
                "Pero los pequeños recordaron el consejo de su madre y no se fiaron.\n" +
                "\n" +
                "- Tu no eres nuestra madre. Nuestra madre tiene la voz suave y tu la tienes muy ronca.\n" +
                "\n" +
                "El lobo se marchó enfadado por haber sido descubierto y fue directo a la tienda donde se compró un trozo de yeso para suavizar su voz. De nuevo volvió a la casa de los siete cabritillos.\n" +
                "\n" +
                "- ¿Quién es?, preguntaron los cabritillos\n" +
                "- Soy yo, vuestra madre.\n" +
                "\n" +
                "Esta vez su voz sonaba suave, así que los cabritillos no estaban seguros del todo. Entonces, vieron por la ventana que su pata era negra como el tizón y se dieron cuenta de que era el lobo.\n" +
                "\n" +
                "- ¡Tu no eres nuestra madre, eres el lobo! Nuestra madre tiene las patas blancas.\n" +
                "\n" +
                "El lobo volvió a marcharse malhumorado pensando en que esta vez lo conseguiría. Fue al molinero y le pidió que le pintase la patita con harina, y aunque al principio el molinero no se fió de él, le entró miedo y acabó accediendo.\n" +
                "\n" +
                "De modo que el lobo volvió a llamar a la puerta.\n" +
                "\n" +
                "- ¿Quién es?, preguntaron los cabritillos\n" +
                "- Soy yo, vuestra madre.\n" +
                "- Enséñanos la patita para que podamos verla\n" +
                "\n" +
                "Al ver los cabritillos que su pata era blanca como la nieve creyeron que de verdad se trataba de su madre y le dejaron pasar. Pero cuando vieron que era el lobo, corrieron despavoridos a esconderse por todos los lugares de la casa. Uno se metió debajo de la cama, otro en el horno, otro en la cocina, otro en el armario, otro en el fregadero y el más pequeño en la caja del reloj.\n" +
                "El lobo fue encontrándolos y comiéndoselos uno por uno, excepto al más pequeño, al que no pudo encontrar.\n" +
                "\n" +
                "Estaba tan harto de comer cuando terminó que se fue a tumbar debajo de un árbol y se quedó profundamente dormido.\n" +
                "\n" +
                "Entretanto llegó mamá cabra y menudo susto se dio cuando vio que toda la casa estaba revuelta y no había ni rastro de sus hijos. Entonces la más pequeña la llamó desde la caja del reloj, su madre la sacó de su escondrijo y le contó lo ocurrido.\n" +
                "\n" +
                "Los siete cabritillos y el lobo\n" +
                "\n" +
                "La vieja cabra cogió tijeras, aguja e hilo y fue con el cabritillo en busca del malvado lobo. Cuando lo encontraron cogió las tijeras y le abrió la tripa al animal. De ahí salieron uno por uno sus seis cabritillos vivos.\n" +
                "\n" +
                "Todos estaban muy contentos de estar sanos y salvos, pero la madre quiso darle al lobo su merecido y ordenó a los pequeños que fueran a por piedras.\n" +
                "\n" +
                "Con astucia, logró la vieja cabra llenar al lobo el estómago de piedras sin que éste lo notara.\n" +
                "\n" +
                "Cuando se despertó, tenía mucha sed y al acercarse al pozo para beber agua, el peso de las piedras hizo que se cayera dentro y se ahogara. Los cabritillos se acercaron al pozo y comenzaron a saltar y cantar en corro alrededor de él celebrando que volvían a estar los siete juntos.');\n" +
                "\n" +
                "\n" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(9,9,'El personaje de Pulgarcito encarna en esta historia el valor del ingenio y la astucia ya que ante cualquier dificultad que se plantea busca siempre una solución y tiene la suerte de salir airoso.\n" +
                "Tal vez, en parte, y aquí estaría otro valor importante, porque a pesar de las dificultades no pierde la esperanza de regresar a casa con riquezas suficientes como para sacar a sus padres de la pobreza.\n" +
                "En último lugar, también, da un ejemplo de sacrificio cuando al final de la historia pide a sus hermanos que regresen a casa y en lugar de hacer él lo mismo, se arriesga para conseguir el objetivo propuesto.','Hace mucho tiempo vivía una hermosa niña que se llamaba Karen. Le apasionaba bailar, por lo que solía pasar varias horas al día danzando por toda la casa. De hecho, a veces se imaginaba a sí misma como una gran bailarina que recibía los aplausos de su público. Sin embargo, su familia era tan pobre que ni siquiera podían comprarle lo que ella más deseaba: unas zapatillas rojas de baile.\n" +
                "\n" +
                "Al morir su madre, una señora adinerada acogió a la niña y la cuidó como si fuera hija suya, encargándose de satisfacer todos sus caprichos. Un día, la llamó y le dijo:\n" +
                "\n" +
                "– Esta tarde iremos a una gran fiesta, cómprate unos zapatos adecuados para la celebración.\n" +
                "\n" +
                "Sin embargo, Karen no le hizo caso a la anciana, aprovechando que la señora no veía muy bien, encargó a la zapatera un par de zapatillas rojas de baile. ¡Las zapatillas eran preciosas! Dignas de una bailarina, por lo que el día de la celebración nadie podía apartar los ojos de los zapatos rojos de Karen.\n" +
                "\n" +
                "Uno de los invitados se acercó a la anciana y le comentó que no estaba bien visto que una niña usara ese color para el calzado. La mujer, enfadada con Karen por haber desobedecido, la reprendió allí mismo:\n" +
                "\n" +
                "\n" +
                "– No deberías haberlo hecho. Me has desobedecido y te has comportado como una niña vanidosa, así no llegarás lejos.\n" +
                "\n" +
                "Sin embargo, la niña hizo caso omiso al regaño y aprovechaba cualquier ocasión para lucir sus preciosos zapatos. Para mala suerte de Karen, la desgracia volvió a llamar a su puerta y su benefactora, la anciana señora, murió al poco tiempo. Para darle el último adiós, se organizó un funeral al que acudieron personas de todas partes de la región.\n" +
                "\n" +
                "Karen estaba desconsolada, pero mientras se vestía para acudir al funeral vio los zapatos rojos brillando en la oscuridad. Sabía que no debía hacerlo, pero, sin pensarlo dos veces, cogió las zapatillas y metió dentro sus piececitos.\n" +
                "\n" +
                "– ¡Estaré mucho más elegante! – dijo para sus adentros y partió hacia el funeral.\n" +
                "\n" +
                "Al entrar en la iglesia, un viejo feo y barbudo se dirigió a ella:\n" +
                "\n" +
                "– ¡Qué zapatillas de baile más bonitas! ¿Quieres que te las limpie? – le preguntó.\n" +
                "\n" +
                "Karen pensó que así los zapatos brillarían más y, sin hacerle caso a lo que la señora siempre le decía sobre vestirse recatadamente, le dio las zapatillas al señor. El hombre miró fijamente las zapatillas y dándole un golpe a las suelas, les ordenó en un susurro:\n" +
                "\n" +
                "– ¡Ajustaos bien cuando bailéis!\n" +
                "\n" +
                " \n" +
                "Al terminar el funeral y salir de la iglesia, Karen comenzó a sentir algo extraño en sus pies. Miro hacia abajo y, sin poder contenerlas, las zapatillas rojas ganaron vida propia y empezaron a moverse siguiendo un extraño ritmo, como si estuvieran poseídas.\n" +
                "\n" +
                "Las personas del pueblo, extrañadas, vieron como Karen se alejaba bailando por las plazas, los prados y los pastos. Por más que lo intentaba, no había forma de quitarse los zapatos, ¡parecían estar pegados a sus pies! Así, pasaron los días y Karen seguía bailando y bailando.\n" +
                "\n" +
                "¡Estaba muy cansada! Nunca antes se había sentido tan sola y triste. Lloraba y lloraba mientras bailaba, pensando en lo tonta y vanidosa que había sido, así como en su actitud ingrata hacia la buena señora y la gente del pueblo que tanto la había ayudado.\n" +
                "\n" +
                "– ¡No puedo más! – gimió desesperada. – Tengo que quitarme estos zapatos aunque para ello sea necesario que me corten los pies.\n" +
                "\n" +
                "Decidida, se dirigió bailando hacia un pueblo cercano donde vivía un verdugo muy famoso por su pericia con el hacha. Cuando llegó, sin dejar de bailar y con lágrimas en los ojos gritó desde la puerta:\n" +
                "\n" +
                "– ¡Sal! ¡Sal! No puedo entrar porque estoy bailando.\n" +
                "\n" +
                "– ¿Es que no sabes quién soy? ¡Yo corto cabezas! – le dijo el verdugo.\n" +
                "\n" +
                "– ¡No, no quiero que me cortes la cabeza! Si lo haces no podré arrepentirme por mi vanidad. Pero por favor, córtame los pies con las zapatillas rojas para que pueda dejar de bailar – le pidió Karen desesperada.\n" +
                "\n" +
                "Sin embargo, grande fue la sorpresa de Karen cuando la puerta se abrió y en vez de ver a un terrible verdugo, vio al mendigo limpiabotas que había encantado sus zapatillas rojas.\n" +
                "\n" +
                "– ¡Qué zapatillas de baile tan bonitas! – exclamó. – ¡Seguro que se ajustan muy bien al bailar! – dijo guiñándole un ojo a la pobre Karen.\n" +
                "\n" +
                "– Déjame verlas de cerca.\n" +
                "\n" +
                "El mendigo acercó sus dedos esqueléticos a los zapatos y las zapatillas rojas se detuvieron. Karen dejó de bailar inmediatamente. Con gran vergüenza le dio las gracias y se marchó a casa. Había aprendido la lección, así que nada más llegar guardó las zapatillas en una urna de cristal y no pasó un solo día en el que no agradeciera por no tener que seguir bailando dentro de aquellas zapatillas rojas.');\n" +
                "\n" +
                "\n" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(10,10,'Este cuento nos demuestra lo lejos que podemos llegar utilizando nuestro ingenio, tal y como hace el gato, que con su astucia es capaz de conseguir algo que a priori parece imposible como es el hecho de que el Rey quiera darle a su amo la mano de su hija.\n" +
                "\n" +
                "Sus esfuerzos por cumplir su objetivo son también un ejemplo de constancia y paciencia, pero sobre todo de generosidad, ya que lo hace para ayudar a su amo sin esperar nada a cambio.','Había una vez un molinero pobre que cuando murió sólo pudo dejar a sus hijos por herencia el molino, un asno y un gato. En el reparto el molino fue para el mayor, el asno para el segundo y el gato para el más pequeño. Éste último se lamentó de su suerte en cuanto supo cuál era su parte.\n" +
                "\n" +
                "- ¿Y ahora qué haré? Mis hermanos trabajarán juntos y harán fortuna, pero yo sólo tengo un pobre gato.\n" +
                "\n" +
                "El gato, que no andaba muy lejos, le contestó:\n" +
                "\n" +
                "- No os preocupéis mi señor, estoy seguro de que os seré más valioso de lo que pensáis.\n" +
                "\n" +
                "- ¿Ah sí? ¿Cómo?, dijo el amo incrédulo\n" +
                "\n" +
                "- Dadme un par de botas y un saco y os lo demostraré.\n" +
                "\n" +
                "El amo no acababa de creer del todo en sus palabras, pero como sabía que era un gato astuto le dio lo que pedía.\n" +
                "\n" +
                "El gato fue al monte, llenó el saco de salvado y de trampas y se hizo el muerto junto a él. Inmediatamente cayó un conejo en el saco y el gato puso rumbo hacia el palacio del Rey.\n" +
                "\n" +
                "- Buenos días majestad, os traigo en nombre de mi amo el marqués de Carabás - pues éste fue el nombre que primero se le ocurrió - este conejo.\n" +
                "\n" +
                "- Muchas gracias gato, dadle las gracias también al señor Marqués de mi parte.\n" +
                "\n" +
                "Al día siguiente el gato cazó dos perdices y de nuevo fue a ofrecérselas al Rey, quien le dio una propina en agradecimiento.\n" +
                "\n" +
                "Los días fueron pasando y el gato continuó durante meses llevando lo que cazaba al Rey de parte del Marqués de Carabás.\n" +
                "\n" +
                "Un día se enteró de que el monarca iba a salir al río junto con su hija la princesa y le dijo a su amo:\n" +
                "\n" +
                "- Haced lo que os digo amo. Acudid al río y bañaos en el lugar que os diga. Yo me encargaré del resto.\n" +
                "\n" +
                "El amo le hizo caso y cuando pasó junto al río la carroza del Rey, el gato comenzó a gritar diciendo que el marqués se ahogaba. Al verlo, el Rey ordenó a sus guardias que lo salvaran y el gato aprovechó para contarle al Rey que unos forajidos habían robado la ropa del marqués mientras se bañaba. El Rey, en agradecimiento por los regalos que había recibido de su parte mandó rápidamente que le llevaran su traje más hermoso. Con él puesto, el marqués resultaba especialmente hermoso y la princesa no tardó en darse cuenta de ello. De modo que el Rey lo invitó a subir a su carroza para dar un paseo.\n" +
                "\n" +
                "El gato se colocó por delante de ellos y en cuanto vio a un par de campesinos segando corrió hacia ellos.\n" +
                "\n" +
                "- Buenas gentes que segáis, si no decís al Rey que el prado que estáis segando pertenece al señor Marqués de Carabás, os harán picadillo como carne de pastel.\n" +
                "\n" +
                "Los campesinos hicieron caso y cuando el Rey pasó junto a ellos y les preguntó de quién era aquél prado, contestaron que del Marqués de Carabás.\n" +
                "\n" +
                "Siguieron camino adelante y se cruzaron con otro par de campesinos a los que se acercó el gato.\n" +
                "\n" +
                "- Buenas gentes que segáis, si no decís al Rey que todos estos trigales pertenecen al señor Marqués de Carabás, os harán picadillo como carne de pastel.\n" +
                "\n" +
                "Y en cuanto el Rey preguntó a los segadores, respondieron sin dudar que aquellos campos también eran del marqués.\n" +
                "\n" +
                "El gato con botasontinuaron su paseo y se encontraron con un majestuoso castillo. El gato sabía que su dueño era un ogro así que fue a hablar con el.\n" +
                "\n" +
                "- He oído que tenéis el don de convertiros en cualquier animal que deseéis. ¿Es eso cierto?\n" +
                "\n" +
                "- Pues claro. Veréis cómo me convierto en león\n" +
                "\n" +
                "Y el ogro lo hizo. El pobre gato se asustó mucho, pero siguió adelante con su hábil plan.\n" +
                "\n" +
                "- Ya veo que están en lo cierto. Pero seguro que no sóis capaces de convertiros en un animal muy pequeño como un ratón.\n" +
                "\n" +
                "- ¿Ah no? ¡Mirad esto!\n" +
                "\n" +
                "El ogro cumplió su palabra y se convirtió en un ratón, pero entonces el gato fue más rápido, lo cazó de un zarpazo y se lo comió.\n" +
                "\n" +
                "Así, cuando el Rey y el Marqués llegaron hasta el castillo no había ni rastro del ogro y el gato pudo decir que se encontraban en el estupendo castillo del Marqués de Carabás.\n" +
                "\n" +
                "El Rey quedó fascinado ante tanto esplendor y acabó pensando que se trataba del candidato perfecto para casarse con su hija.\n" +
                "\n" +
                "El Marqués y la princesa se casaron felizmente y el gato sólo volvió a cazar ratones para entretenerse.');";

        String cuento5 ="INSERT INTO MisCONTENIDOCUENTOS VALUES(5,5,'La aventura en Liliput de Los viajes de Gulliver tiene un mensaje muy actual, ¿no os parece? Habla de cómo las sociedades juzgan al diferente, que puede ser un «extranjero» o alguien que come los huevos por el lado que creen equivocado. La moraleja del cuento es que no se debe juzgar a las personas de manera superficial, basándonos en las diferencias en vez que en que nos une como seres humanos.','Erase una vez un hombre que se llamaba Gulliver. Era médico de un barco y a menudo emprendía viajes que le llevaban a tierras muy lejanas. En uno de esos viajes, a bordo del mercante Antílope, no podía ni imaginar cuán lejos le llevaría el barco ni qué asombrosas aventuras le aguardaban.\n" +
                "\n" +
                "Después de muchos meses navegando, el barco se acercó a las costas de una tierra desconocida. De pronto estalló una terrible tormenta y el viento arrojó al Antílope contra las rocas. Inmediatamente, el barco se partió en dos. Antes de que se hundiera, los tripulantes, aterrados, se tiraron por la borda. Sólo Gulliver consiguió nadar a través del furioso oleaje y llegar a tierra sano y salvo. Los otros marineros se ahogaron todos.\n" +
                "\n" +
                "Una vez fuera del agua, Gulliver se arrastró por la playa. Luego, completamente agotado, quedó sumido en un profundo sueño. Al despertar, sin idea de cuánto tiempo había estado durmiendo, el sol brillaba intensamente en sus ojos. Soltó un gemido e intentó estirarse, pero comprobó horrorizado que no podía moverse. ¡Tenía los brazos, las piernas y la espesa cabellera firmemente sujetos al suelo!\n" +
                "\n" +
                "Entonces sintió que algo le subía por la pierna. Levantó la cabeza cuanto pudo y vio a un diminuto personaje -no mayor que su dedo meñique-caminando sobre su pecho. Luego vio con asombro que al menos otros cuarenta hombrecillos trepaban por todo el cuerpo ¡armados con pequeños arcos y flechas!\n" +
                "\n" +
                "Lanzando un enorme grito, Gulliver trató de liberarse. Rugió tan violentamente que muchos de los hombrecillos que se habían encaramado a él cayeron al suelo; los otros salieron huyendo. Pero al ver que Gulliver no podía soltarse, se volvieron y le lanzaron una lluvia de flechas, tan pequeñas y afiladas como agujas.\n" +
                "\n" +
                "—¡Ay! ¡Ay! -exclamó Gulliver al sentir las flechas que le herían en la cara. Más tarde, otra rociada de flechas le dio en el pecho .y en las manos. Retorciéndose de dolor, Gulliver trató desesperadamente de romper los miles de hilos que le sujetaban al suelo.\n" +
                "\n" +
                "Pero era inútil luchar: las ligaduras eran demasiado fuertes. Por fin, Gulliver se dio por vencido. Permaneció tendido en silencio y poco a poco le fue venciendo el sueño. Al cabo de un rato le despertó el ruido de martillazos. Volviendo otra vez la cabeza cuanto pudo, vio que junto a él habían construido una pequeña plataforma de madera y un hombrecillo, elegantemente vestido, se encaramaba a ella lentamente.\n" +
                "\n" +
                "-¡Hilo bigismo ad poples Liliput! Ig Golbasto magnifelus Emperoribory… -gritó el hombrecillo al oído de Gulliver.\n" +
                "\n" +
                "Gulliver le respondió: -No comprendo. ¿Dice usted que su país se llama Liliput?\n" +
                "\n" +
                "\n" +
                "Gulliver trató de hacerle entender al hombrecillo que estaba hambriento y sediento. Pero cuando le trajeron una bebida, ¡resultó estar drogada! Total que quedó dormido.\n" +
                "\n" +
                "\n" +
                "Mientras dormía, quinientos carpinteros e ingenieros construyeron una estrecha carreta de madera para trasladarlo a ver al emperador de Liliput. Fueron necesarios novecientos hombres armados con palos para colocarlo sobre la carreta y más de mil caballos para transportarlo a la ciudad.\n" +
                "\n" +
                "La procesión se detuvo a las afueras de la población, junto a las ruinas de un viejo templo. Allí fue trasladado Gulliver, donde le colocaron pesadas cadenas en las piernas aseguradas con cientos de candados.\n" +
                "\n" +
                "Cuando se despertó, Gulliver comprobó que habían cortado todas las ligaduras que le sujetaban. Se levantó despacio y miró a su alrededor. Asombrado, vio a sus pies una ciudad entera en miniatura, con casas, calles y parques. Miles de personajillos le contemplaban con la boca abierta.\n" +
                "\n" +
                "A cierta distancia de la muchedumbre había un magnífico caballo, sobre el cual iba sentado el emperador, de porte majestuoso. Más alto y bien parecido que el resto de la gente que había visto hasta entonces Gulliver, el emperador de Liliput lucía un casco de oro, incrustado con piedras preciosas y decorado con un airoso penacho. En su diestra sostenía una espada casi tan grande como él, con la empuñadura engarzada con brillantes. El caballo, al ver a Gulliver, se encabritó asustado; entonces el emperador desmontó y caminó majestuosamente en torno a los enormes pies de Gulliver.\n" +
                "\n" +
                "Cerca del templo había una elevada torre, casi tan alta como el propio Gulliver y, con mucho, el edificio más alto de Liliput. El emperador y sus cortesanos subieron las escaleras de la torre para ver mejor a Gulliver. Luego se dirigieron a él a través de bocinas. Pero aunque Gulliver les habló en inglés, alemán, francés, español e italiano, aquéllos parecían no entender una palabra de lo que les decía, y él no lograba entenderles a ellos. El emperador bajó de la torre y dio unas palmadas. De inmediato le fueron llevadas al gigante veinte carretas repletas de carne y pan.\n" +
                "\n" +
                "\n" +
                "Al mirar a la multitud que había congregada a sus pies, Gulliver pudo distinguir a las damas de la corte por sus lujosos ropajes. Cuando se inclinaron ante él con una reverencia, sus mantos de raso y las colas plateadas lanzaban destellos. Eran todas tan bonitas que Gulliver sintió deseos de tomar a una en sus manos para examinar «más de cerca sus diminutos vestidos. Pero era demasiado educado para hacer semejante cosa.\n" +
                "\n" +
                "\n" +
                "Las elegantes damas de la corte parecían escandalizadas y se taparon los ojos cuando vieron a Gulliver tomar cada carreta una por una y engullir la comida que le habían ofrecido. Al verle tragar barriles enteros de vino algunas hasta se desmayaron.\n" +
                "\n" +
                "Al fin terminó la visita real y Gulliver se quedó a solas en el templo…, a solas, exceptuando a los cientos de soldaditos que le custodiaban.\n" +
                "\n" +
                "Pero no todos los habitantes de Liliput se sentían felices de tener a un gigante encadenado tan cerca de la población. Aquella noche, un grupo de hombres se deslizaron furtivamente entre los guardias y atacaron a Gulliver con sus flechas, lanzas y cuchillos. Rápidamente fueron rodeados por la guardia personal del emperador, que les ataron las manos a la espalda. Con el puño de su afilada lanza, el capitán de la guardia fue empujando a los atacantes más y más cerca de las manos extendidas de Gulliver, al tiempo que parecía decir:\n" +
                "\n" +
                "-Han intentado matarte, gigante. ¡Encárgate tú de ellos!\n" +
                "\n" +
                "Gulliver tomó en sus manos a sus atacantes y se metió a cinco en el bolsillo. Al sexto lo sostuvo frente a su boca abierta como si fuera a tragárselo. ¡Cómo gritaba y chillaba aquel hombrecillo!\n" +
                "\n" +
                " \n" +
                "Pero Gulliver lo depositó suavemente en el suelo y luego colocó a los otros cinco junto a él. Rápidos como el rayo, todos salieron corriendo tan deprisa como se lo permitían sus piernecillas.\n" +
                "\n" +
                "Toda Liliput estaba asombrada de la benevolencia mostrada por Gulliver hacia los hombres que habían intentado matarlo y corrieron a darle la noticia al emperador. Todos los ministros de Estado se hallaban reunidos en la corte para discutir lo que había de hacerse con el extraño gigante que las olas habían arrojado a la playa de Liliput.\n" +
                "\n" +
                "-¡Ehg, likibugal bigismo avidaly! -dijo el emperador, lo cual significaba: «está claro que es un gigante amigable, no hay nada que temer». Pero Gulliver se sentía muy solo encadenado en el templo y deseaba poder huir y volver a su casa junto a su esposa y sus hijos.\n" +
                "\n" +
                "Al descubrir que Gulliver no quería hacerles ningún daño y que era un hombre pacífico y amable, la gente de Liliput lo desató y lo dejó en libertad.\n" +
                "\n" +
                "—Pero debes dar vuelta a tus bolsillos —dijo el emperador— para asegurarnos de que no llevas armas peligrosas.\n" +
                "\n" +
                "Gulliver, que ya entendía algunas palabras del idioma liliputiense, se vació los bolsillos y colocó sus pertenencias en el suelo. El emperador se sorprendió tanto de lo que vio que dejó que toda la gente de Liliput se acercase a mirar aquellos objetos maravillosos.\n" +
                "\n" +
                "—Ahora debes prometerme que vivirás en paz con todos los liliputienses -dijo el emperador Golbasto— y que defenderás a Liliput de sus enemigos.\n" +
                "\n" +
                "—Me sorprende oír que tenéis enemigos, Majestad —dijo Gulliver, cortés.\n" +
                "\n" +
                "—¡Oh, sí! Estamos en guerra con la gente de Blefuscu. ¿No lo sabías? Viven en una isla del otro lado del mar.\n" +
                "\n" +
                "Poniéndose de puntillas, Gulliver pudo ver la isla. En realidad, no estaba muy lejos: sólo un estrecho la separaba de Liliput.\n" +
                "\n" +
                "El puerto de Blefuscu se encontraba al amparo de los acantilados de la isla, y en él había una flota de cincuenta barcos de guerra, que no eran más grandes que los barcos de juguete con los que había jugado Gulliver de pequeño.\n" +
                "\n" +
                "—Traedme cincuenta barras de hierro —dijo Gulliver.\n" +
                "\n" +
                "La gente de Liliput se esforzaba y sudaba bajo el peso de las cincuenta vigas. Eran del tamaño de un alfiler.\n" +
                "\n" +
                "Gulliver las dobló una tras otra, transformándolas en anzuelos.\n" +
                "\n" +
                "—Ahora traedme la cuerda más fuerte del país.\n" +
                "\n" +
                "Los liliputienses le llevaron un fino hilo. Gulliver ató el hilo a los anzuelos y entró en el agua caminando.\n" +
                "\n" +
                "Nadó unos minutos en dirección a Blefuscu. Al llegar a aguas poco profundas, Gulliver se puso en pie y caminó hacia la costa.\n" +
                "\n" +
                "En la playa se habían reunido treinta mil soldados y marinos de Blefuscu, que iban a invadir Liliput. Pero la aparición de Gulliver, que surgió de las aguas, llenó sus treinta mil corazones de pánico.\n" +
                "\n" +
                "—¡Giganticus! —gritaron, creyendo que Liliput había contratado a un horrible gigante para luchar contra ellos—. ¡Gentelilli enviagor ferrífero gigantico! ¡Mató ranos!\n" +
                "\n" +
                "Los marineros de las cincuenta naves de guerra se tiraron por la borda y escaparon nadando para salvarse. Los soldados arrojaron sus arcos y sus flechas, y huyeron a esconderse en las montañas del interior del país.\n" +
                "\n" +
                "Gulliver se detuvo en la playa, sacó los hilos y los anzuelos que llevaba y los fue enganchando uno tras otro a la proa de todos los barcos del puerto. Cortó las cadenas de las anclas con su cortaplumas y, luego, tirando de los cincuenta hilos, sacó los barcos del puerto y los llevó a Liliput.\n" +
                "\n" +
                "La gente de Liliput gritó hasta quedar ronca al ver a Gulliver acarreando la flota con las cincuenta cuerdecillas. Cuando llegó a tierra, le aclamaron.\n" +
                "\n" +
                "—¡Tres hurras para el Hombre Montaña! Ha salvado a Liliput.\n" +
                "\n" +
                "Gulliver llevó los barcos al Puerto Real y luego fue a visitar al emperador.\n" +
                "\n" +
                "—Ahora explicadme —dijo, agachándose junto a palacio— ¿Por qué estáis en guerra con Blefuscu?\n" +
                "\n" +
                "—¡Porque son muy malos! —contestó el emperador Golbasto, que aún bailaba de alegría por la noticia de la victoria—. ¡Comen los huevos pasados por agua agujereando la parte redonda! ¿Te lo imaginas? ¡Es una costumbre repugnante! Pero ahora los hemos derrotado y los obligaremos a comerlos por la parte puntiaguda.\n" +
                "\n" +
                "Gulliver no podía creer lo que oía.\n" +
                "\n" +
                "—¿Estáis en guerra por eso? De haberlo sabido, nunca os habría ayudado.\n" +
                "\n" +
                "De repente, se sintió muy solo entre toda aquella gente. Tenía ganas de volver a casa.\n" +
                "\n" +
                "Le daban mucha pena los blefuscus que había derrotado y decidió visitar la isla para disculparse. Cuando el emperador Golbasto se enteró de lo que había hecho, se puso furioso.\n" +
                "\n" +
                "—¡Traición! ¡Es un traidor a Liliput! ¡Lo mataré! ¡Envenenad su bebida!\n" +
                "\n" +
                "¡Incendiad su casa! ¡Probablemente en este momento esté comiendo un huevo por la parte redonda!\n" +
                "\n" +
                "El primer ministro señaló que les era muy útil tener un gigante a su servicio.\n" +
                "\n" +
                "—No creo que tengamos que matar al Hombre Montaña, Majestad.\n" +
                "\n" +
                "-Bueno -replicó Golbasto—, en vez de eso, le arrancaré los ojos.\n" +
                "\n" +
                "Enviaron al heraldo de la corte a anunciar el castigo. Gulliver acababa de volver de Blefuscu y se había echado al sol mientras se le secaban las ropas. El heraldo se detuvo junto a su oreja y tocó una rara trompeta.\n" +
                "\n" +
                "-Oh, Hombre Montaña, extranjero y traidor —leyó en un pergamino—, el glorioso emperador Golbasto ha decidido perdonarte la vida.\n" +
                "\n" +
                "Gulliver se puso de pie y miró al heraldo.\n" +
                "\n" +
                "—Pero como has traicionado a la nación de Liliput, los arqueros reales te arrancarán los ojos con sus agudas flechas, mañana al mediodía. ¡Dios salve a Golbasto!\n" +
                "\n" +
                "Gulliver recogió sus escasas pertenencias y atravesó corriendo la ciudad hasta el puerto. Allí se encontraba el galeón real de Golbasto, que era el barco más grande de toda la flota liliputiense.\n" +
                "\n" +
                "Cargó su chaqueta, su pistola y su sombrero en el galeón, lo sacó del pequeño puerto y salió nadando al mar. No miró atrás ni una sola vez; lo único que oía era el sonido de las olas a su alrededor.\n" +
                "\n" +
                "Después de un rato, trepó al galeón. Era del tamaño de una cuna y se veía obligado a sacar los brazos y las piernas por el borde. El viento y la corriente del agua lo llevaron a través del océano. Arrullado por el suave movimiento del galeón, Gulliver cayó en un profundo sueño.\n" +
                "\n" +
                "Entonces, desde lo alto del palo mayor de un barco mercante, un marinero descubrió el galeón con su catalejos.\n" +
                "\n" +
                "Primero pensó que era un barril que había caído al mar, pero después vio a Gulliver.\n" +
                "\n" +
                "En seguida despacharon un bote para recogerle.\n" +
                "\n" +
                "Gulliver dio las gracias al capitán por haberle salvado; con el galeón bajo el brazo, descendió a su camarote. ¡Por primera vez en varios meses, iba a dormir en una cama! Durante el largo viaje a casa, se sentó todas las noches a cenar en la mesa del capitán y le contó sus extraordinarias aventuras en Liliput.');";


        String cuento6 ="INSERT INTO MisCONTENIDOCUENTOS VALUES(6,6,'Este cuento nos enseña el valor del respeto a los demás y a su intimidad. Lo hace a través del personaje de Ricitos de Oro, que no muestra ningún respeto por los osos ni por sus cosas, entrando sin permiso en su casa y comiéndose su comida. La consecuencia de haber hecho las cosas mal la encontramos en el final del cuento con el gran susto que se lleva la niña.','Había una vez una casita en el bosque en la que vivían papá oso, que era grande y fuerte; mamá osa, que era dulce y redonda; y el pequeño bebé oso.\n" +
                "\n" +
                "Todas las mañanas mamá osa preparaba con cariño el desayuno de los tres. Un gran bol de avena para papá oso, otro mediano para ella y un bol pequeñito para el bebé oso. Antes de desayunar salían los tres juntos a dar un paseo por el bosque.\n" +
                "\n" +
                "Un día, durante ese paseo llegó una niña hasta la casa de los tres osos. Estaba recogiendo juncos en el bosque pero se había adentrado un poco más de la cuenta.\n" +
                "\n" +
                "- ¡Pero qué casa tan bonita! ¿Quién vivirá en ella? Voy a echar un vistazo\n" +
                "\n" +
                "Era una niña rubia con el pelo rizado como el oro y a la que todos llamaban por eso Ricitos de Oro. Como no vio nadie en la casa y la puerta estaba abierta Ricitos decidió entrar.\n" +
                "\n" +
                "Lo primero que vio es que había tres sillones en el salón. Se sentó en el más grande de todos, el de papá oso, pero lo encontró muy duro y no le gustó. Se sentó en el mediano, el de mamá osa, pero le pareció demasiado mullido; y después se sentó después en la mecedora del bebé oso. Pero aunque era de su tamaño, no tuvo cuidado y la rompió.\n" +
                "\n" +
                "Rápidamente salió de ahí y fue entonces cuando entró en la cocina y se encontró con los tres boles de avena.\n" +
                "\n" +
                "- ¡Mmmm que bien huele!\n" +
                "\n" +
                "Decidió probar un poquito del más grande, el de papá oso. Pero estaba demasiado caliente y se quemó. Probó del mediano, el de mamá osa, pero lo encontró demasiado salado y tampoco le gustó. De modo que decidió probar el más pequeño de todos.\n" +
                "\n" +
                "-¡Qué rico! Está muy dulce, como a mi me gusta.\n" +
                "\n" +
                "Así que Ricitos de oro se lo comió todo entero. Cuando acabó le entró sueño y decidió dormir la siesta. En el piso de arriba encontró una habitación con tres camas. Trató de subirse a la más grande, pero no llegaba porque era la cama de papá oso. Probó entonces la cama de mamá osa, pero la encontró demasiado mullida así que acabó por acostarse en la cama de bebé oso, que era de su tamaño y allí se quedó plácidamente dormida.\n" +
                "\n" +
                "Entonces llegaron los tres osos de su paseo y rápidamente se dieron cuenta de que alguien había entrado en su casa.\n" +
                "\n" +
                "- ¡Alguien se ha sentado en mi sillón! - gritó papá oso enfadado\n" +
                "\n" +
                "- En el mío también - dijo mamá osa con voz dulce\n" +
                "\n" +
                "Ricitos de oro y los tres osos- Y alguien ha roto mi mecedora - dijo bebé oso muy triste\n" +
                "\n" +
                "Entraron en la cocina y vieron lo que había pasado con su desayuno.\n" +
                "\n" +
                "- ¡Alguien ha probado mi desayuno! - gritó papá oso enfadado\n" +
                "\n" +
                "- Parece que el mío también - dijo mamá osa dijo mamá osa con voz dulce\n" +
                "\n" +
                "- Y alguien se ha comido el mío - dijo bebé oso llorando\n" +
                "\n" +
                "De repente el bebé oso miró hacia la habitación y descubrió a su invitada.\n" +
                "\n" +
                "- ¡Mirad! ¡Hay una niña en mi cama!\n" +
                "\n" +
                "Justo en ese instante Ricitos de oro se despertó y al ver a los tres osos delante de ella saltó de la cama y echó a correr lo más rápido que pudieron sus pies hasta llegar a su casa, dejando atrás incluso sus zapatos.');\n";

        String Cuentos11_16 = "INSERT INTO MisCONTENIDOCUENTOS VALUES(11,11,'El cuento es especialmente útil para explicar el significado de un valor negativo como es la envidia, a través del personaje de la malvada Reina. Asimismo, nos habla de lo importante que es la obediencia, y nos muestra un ejemplo de lo que ocurre cuando no se obedecen los consejos de las personas que nos quieren. Es lo que sucede con Blancanieves, a quien los enanitos dicen que no debe abrir y sin embargo acaba haciéndolo.\n" +
                "Por otro lado, nos muestra algo positivo como es la generosidad, a través de los personajes de los siete enanitos, que acogen a Blancanieves sin conocerla de nada y cuidan de ella.','Un día de invierno la Reina miraba cómo caían los copos de nieve mientras cosía. Le cautivaron de tal forma que se despistó y se pinchó en un dedo dejando caer tres gotas de la sangre más roja sobre la nieve. En ese momento pensó:\n" +
                "\n" +
                "- Cómo desearía tener una hija así, blanca como la nieve, sonrosada como la sangre y de cabellos negros como el ébano.\n" +
                "\n" +
                "Al cabo de un tiempo su deseo se cumplió y dio a luz a una niña bellísima, blanca como la nieve, sonrosada como la sangre y con los cabellos como el ébano. De nombre le pusieron Blancanieves, aunque su nacimiento supuso la muerte de su madre.\n" +
                "\n" +
                "Pasados los años el rey viudo decidió casarse con otra mujer. Una mujer tan bella como envidiosa y orgullosa. Tenía ésta un espejo mágico al que cada día preguntaba:\n" +
                "\n" +
                "- Espejito espejito, contestadme a una cosa ¿no soy yo la más hermosa?\n" +
                "\n" +
                "Y el espejo siempre contestaba:\n" +
                "\n" +
                "- Sí, mi Reina. Vos sois la más hermosa.\n" +
                "\n" +
                "Pero el día en que Blancanieves cumplió siete años el espejo cambió su respuesta:\n" +
                "\n" +
                "- No, mi Reina. La más hermosa es ahora Blancanieves.\n" +
                "\n" +
                "\n" +
                "Al oír esto la Reina montó en cólera. La envidia la comía por dentro y tal era el odio que sentía por ella que acabó por ordenar a un cazador que la llevara al bosque, la matara y volviese con su corazón para saber que había cumplido con sus órdenes.\n" +
                "\n" +
                "Pero una vez en el bosque el cazador miró a la joven y dulce Blancanieves y no fue capaz de hacerlo. En su lugar, mató a un pequeño jabalí que pasaba por allí para poder entregar su corazón a la Reina.\n" +
                "\n" +
                "Blancanieves se quedó entonces sola en el bosque, asustada y sin saber dónde ir. Comenzó a correr hasta que cayó la noche. Entonces vio luz en una casita y entró en ella.\n" +
                "\n" +
                "Era una casita particular. Todo era muy pequeño allí. En la mesa había colocados siete platitos, siete tenedores, siete cucharas, siete cuchillos y siete vasitos. Blancanieves estaba tan hambrienta que probó un bocado de cada plato y se sentó como pudo en una de las sillitas.\n" +
                "\n" +
                "Estaba tan agotada que le entró sueño, entonces encontró una habitación con siete camitas y se acurrucó en una de ellas.\n" +
                "\n" +
                "Bien entrada la noche regresaron los enanitos de la mina, donde trabajaban excavando piedras preciosas. Al llegar se dieron cuenta rápidamente de que alguien había estado allí.\n" +
                "\n" +
                "- ¡Alguien ha comido de mi plato!, dijo el primero\n" +
                "- ¡Alguien ha usado mi tenedor!, dijo el segundo\n" +
                "- ¡Alguien ha bebido de mi vaso!, dijo el tercero\n" +
                "- ¡Alguien ha cortado con mi cuchillo!, dijo el cuarto\n" +
                "- ¡Alguien se ha limpiado con mi servilleta!, dijo el quinto\n" +
                "- ¡Alguien ha comido de mi pan!, dijo el sexto\n" +
                "- ¡Alguien se ha sentado en mi silla!, dijo el séptimo\n" +
                "\n" +
                "Cuando entraron en la habitación desvelaron el misterio sobre lo ocurrido y se quedaron con la boca abierta al ver a una muchacha tan bella. Tanto les gustó que decidieron dejar que durmiera.\n" +
                "\n" +
                "Al día siguiente Blancanieves les contó a los enanitos la historia de cómo había llegado hasta allí. Los enanitos sintieron mucha lástima por ella y le ofrecieron quedarse en su casa. Pero eso sí, le advirtieron de que tuviera mucho cuidado y no abriese la puerta a nadie cuando ellos no estuvieran.\n" +
                "\n" +
                "La madrastra mientras tanto, convencida de que Blancanieves estaba muerta, se puso ante su espejo y volvió a preguntarle:\n" +
                "\n" +
                "- Espejito espejito, contestadme a una cosa ¿no soy yo la más hermosa?\n" +
                "- Mi Reina, vos sois una estrella pero siento deciros que Blancanieves, sigue siendo la más bella.\n" +
                "\n" +
                "La reina se puso furiosa y utilizó sus poderes para saber dónde se escondía la muchacha. Cuando supo que se encontraba en casa de los enanitos, preparó una manzana envenenada, se vistió de campesina y se encaminó hacia montaña.\n" +
                "\n" +
                "Cuando llegó llamó a la puerta. Blancanieves se asomó por la ventana y contestó:\n" +
                "\n" +
                "- No puedo abrir a nadie, me lo han prohibido los enanitos.\n" +
                "- No temas hija mía, sólo vengo a traerte manzanas. Tengo muchas y no sé qué hacer con ellas. Te dejaré aquí una, por si te apetece más tarde.\n" +
                "\n" +
                "Blancanieves se fió de ella, mordió la manzana y… cayó al suelo de repente.\n" +
                "\n" +
                "La malvada Reina que la vio, se marchó riéndose por haberse salido con la suya. Sólo deseaba llegar a palacio y preguntar a su espejo mágico quién era la más bella ahora.\n" +
                "\n" +
                "- Espejito espejito, contestadme a una cosa ¿no soy yo la más hermosa?\n" +
                "- Sí, mi Reina. De nuevo vos sois la más hermosa.\n" +
                "\n" +
                "Cuando los enanitos llegaron a casa y se la encontraron muerta en el suelo a Blancanieves trataron de ver si aún podían hacer algo, pero todos sus esfuerzos fueron en vano. Blancanieves estaba muerta.\n" +
                "\n" +
                "De modo que puesto que no podían hacer otra cosa, mandaron fabricar una caja de cristal, la colocaron en ella y la llevaron hasta la cumpre de la montaña donde estuvieron velándola por mucho tiempo. Junto a ellos se unieron muchos animales del bosque que lloraban la pérdida de la muchacha. Pero un día apareció por allí un príncipe que al verla, se enamoró de inmediato de ella, y le preguntó a los enanitos si podía llevársela con él.\n" +
                "\n" +
                "A los enanitos no les convencía la idea, pero el príncipe prometió cuidarla y venerarla, así que accedieron.\n" +
                "\n" +
                "Cuando los hombres del príncipe transportaban a Blancanieves tropezaron con una piedra y del golpe, salió disparado el bocado de manzana envenenada de la garganta de Blancanieves. En ese momento, Blancanieves abrió los ojos de nuevo.\n" +
                "\n" +
                "- ¿Dónde estoy? ¿Qué ha pasado?, preguntó desorientada Blancanieves\n" +
                "- Tranquila, estáis sana y salva por fin y me habéis hecho con eso el hombre más afortunado del mundo.\n" +
                "\n" +
                "Blancanieves y el Príncipe se convirtieron en marido y mujer y vivieron felices en su castillo.');" +
                "\n" +
                "\n" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(12,12,'Érase una vez un bosque donde vivían muchos animales y donde todos eran muy amiguitos. Una mañana un pequeño conejo llamado Tambor fue a despertar al búho para ir a ver un pequeño cervatillo que acababa de nacer. Se reunieron todos los animalitos del bosque y fueron a conocer a Bambi, que así se llamaba el nuevo cervatillo. Todos se hicieron muy amigos de él y le fueron enseñando todo lo que había en el bosque: las flores, los ríos y los nombres de los distintos animales, pues para Bambi todo era desconocido.\n" +
                "\n" +
                "Todos los días se juntaban en un claro del bosque para jugar. Una mañana, la mamá de Bambi lo llevó a ver a su padre que era el jefe de la manada de todos los ciervos y el encargado de vigilar y de cuidar de ellos. Cuando estaban los dos dando un paseo, oyeron ladridos de un perro. “¡Corre, corre Bambi! -dijo el padre- ponte a salvo”. “¿Por qué, papi?”, preguntó Bambi. Son los hombres y cada vez que vienen al bosque intentan cazarnos, cortan árboles, por eso cuando los oigas debes de huir y buscar refugio.\n" +
                "\n" +
                "Pasaron los días y su padre le fue enseñando todo lo que debía de saber pues el día que él fuera muy mayor, Bambi sería el encargado de cuidar a la manada. Más tarde, Bambi conoció a una pequeña cervatilla que era muy muy guapa llamada Farina y de la que se enamoró enseguida. Un día que estaban jugando las dos oyeron los ladridos de un perro y Bambi pensó: “¡Son los hombres!”, e intentó huir, pero cuando se dio cuenta el perro estaba tan cerca que no le quedó más remedio que enfrentarse a él para defender a Farina. Cuando ésta estuvo a salvo, trató de correr pero se encontró con un precipicio que tuvo que saltar, y al saltar, los cazadores le dispararon y Bambi quedó herido.\n" +
                "\n" +
                "Pronto acudió su papá y todos sus amigos y le ayudaron a pasar el río, pues sólo una vez que lo cruzaran estarían a salvo de los hombres, cuando lo lograron le curaron las heridas y se puso bien muy pronto.\n" +
                "\n" +
                "Pasado el tiempo, nuestro protagonista había crecido mucho. Ya era un adulto. Fue a ver a sus amigos y les costó trabajo reconocerlo pues había cambiado bastante y tenía unos cuernos preciosos. El búho ya estaba viejecito y Tambor se había casado con una conejita y tenían tres conejitos. Bambi se casó con Farina y tuvieron un pequeño cervatillo al que fueron a conocer todos los animalitos del bosque, igual que pasó cuando él nació. Vivieron todos muy felices y Bambi era ahora el encargado de cuidar de todos ellos, igual que antes lo hizo su papá, que ya era muy mayor para hacerlo.','Érase una vez un bosque donde vivían muchos animales y donde todos eran muy amiguitos. Una mañana un pequeño conejo llamado Tambor fue a despertar al búho para ir a ver un pequeño cervatillo que acababa de nacer. Se reunieron todos los animalitos del bosque y fueron a conocer a Bambi, que así se llamaba el nuevo cervatillo. Todos se hicieron muy amigos de él y le fueron enseñando todo lo que había en el bosque: las flores, los ríos y los nombres de los distintos animales, pues para Bambi todo era desconocido.\n" +
                "\n" +
                "Todos los días se juntaban en un claro del bosque para jugar. Una mañana, la mamá de Bambi lo llevó a ver a su padre que era el jefe de la manada de todos los ciervos y el encargado de vigilar y de cuidar de ellos. Cuando estaban los dos dando un paseo, oyeron ladridos de un perro. “¡Corre, corre Bambi! -dijo el padre- ponte a salvo”. “¿Por qué, papi?”, preguntó Bambi. Son los hombres y cada vez que vienen al bosque intentan cazarnos, cortan árboles, por eso cuando los oigas debes de huir y buscar refugio.\n" +
                "\n" +
                "Pasaron los días y su padre le fue enseñando todo lo que debía de saber pues el día que él fuera muy mayor, Bambi sería el encargado de cuidar a la manada. Más tarde, Bambi conoció a una pequeña cervatilla que era muy muy guapa llamada Farina y de la que se enamoró enseguida. Un día que estaban jugando las dos oyeron los ladridos de un perro y Bambi pensó: “¡Son los hombres!”, e intentó huir, pero cuando se dio cuenta el perro estaba tan cerca que no le quedó más remedio que enfrentarse a él para defender a Farina. Cuando ésta estuvo a salvo, trató de correr pero se encontró con un precipicio que tuvo que saltar, y al saltar, los cazadores le dispararon y Bambi quedó herido.\n" +
                "\n" +
                "Pronto acudió su papá y todos sus amigos y le ayudaron a pasar el río, pues sólo una vez que lo cruzaran estarían a salvo de los hombres, cuando lo lograron le curaron las heridas y se puso bien muy pronto.\n" +
                "\n" +
                "Pasado el tiempo, nuestro protagonista había crecido mucho. Ya era un adulto. Fue a ver a sus amigos y les costó trabajo reconocerlo pues había cambiado bastante y tenía unos cuernos preciosos. El búho ya estaba viejecito y Tambor se había casado con una conejita y tenían tres conejitos. Bambi se casó con Farina y tuvieron un pequeño cervatillo al que fueron a conocer todos los animalitos del bosque, igual que pasó cuando él nació. Vivieron todos muy felices y Bambi era ahora el encargado de cuidar de todos ellos, igual que antes lo hizo su papá, que ya era muy mayor para hacerlo.');" +
                "\n" +
                "\n" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(13,13,'Moraleja: No digas mentiras, ya que el día que cuentes la verdad, nadie te creerá. ','Érase una vez un joven pastor llamado Pedro que se pasaba el día con sus ovejas. Cada mañana muy temprano las sacaba al aire libre para que pastaran y corretearan por el campo. Mientras los animales disfrutaban a sus anchas, Pedro se sentaba en una roca y las vigilaba muy atento para que ninguna se extraviara.\n" +
                "\n" +
                "\n" +
                "Un día, justo antes del atardecer, estaba muy aburrido y se le ocurrió una idea para divertirse un poco: gastarle una broma a sus vecinos. Subió a una pequeña colina que estaba a unos metros de donde se encontraba el ganado y comenzó a gritar:\n" +
                "\n" +
                "– ¡Socorro! ¡Auxilio! ¡Que viene el lobo! ¡Que viene el lobo, ayuda por favor!\n" +
                "\n" +
                "Los habitantes de la aldea se sobresaltaron al oír esos gritos tan estremecedores y salieron corriendo en ayuda de Pedro. Cuando llegaron junto a él, encontraron al chico riéndose a carcajadas.\n" +
                "\n" +
                "– ¡Ja ja ja! ¡Os he engañado a todos! ¡No hay ningún lobo!\n" +
                "\n" +
                "Los aldeanos, enfadados, se dieron media vuelta y regresaron a la aldea.\n" +
                "\n" +
                "Al día siguiente, Pedro regresó con sus ovejas al campo. Empezó a aburrirse sin nada que hacer más que mirar la hierba y las nubes ¡Qué largos se le hacían los días! … Decidió que sería divertido repetir la broma de la otra tarde.\n" +
                "\n" +
                "Subió a la misma colina y cuando estaba en lo más alto, comenzó a gritar:\n" +
                "\n" +
                "– ¡Socorro! ¡Socorro! ¡Necesito ayuda! ¡He visto un enorme lobo atemorizando a mis ovejas!\n" +
                "\n" +
                "Pedro gritaba tanto que su voz se oía en todo el valle. Un grupo de hombres se reunió en la plaza del pueblo y se organizó rápidamente para acudir en ayuda del joven. Todos juntos se pusieron en marcha  y enseguida vieron al pastor, pero el lobo no estaba por ninguna parte. Al acercarse, sorprendieron al joven riéndose a mandíbula batiente.\n" +
                "\n" +
                "– ¡Ja ja ja! ¡Me parto de risa! ¡Os he vuelto a engañar, pardillos! ¡ja ja ja!\n" +
                "\n" +
                "\n" +
                "Los hombres, realmente indignados, regresaron a sus casas. No entendían cómo alguien podía gastar unas bromas tan pesadas y de tan mal gusto.\n" +
                "\n" +
                "El verano llegaba a su fin y Pedro seguía, día tras día, acompañando a sus ovejas al campo. Las jornadas pasaban lentas y necesitaba entretenerse con algo que no fuera oír balidos.\n" +
                "\n" +
                " Una tarde, entre bostezo y bostezo, escuchó un gruñido detrás de los árboles. Se frotó los ojos y vio un sigiloso lobo que se acercaba a sus animales. Asustadísimo, salió pitando hacia lo alto de la colina y comenzó a chillar como un loco:\n" +
                "\n" +
                "– ¡Socorro! ¡Auxilio! ¡Socorro! ¡Ayúdenme! ¡Ha venido el lobo!\n" +
                "\n" +
                "Como siempre, los aldeanos escucharon los alaridos de Pedro, pero creyendo que se trataba de otra mentira del chico,  siguieron con sus faenas y no le hicieron ni caso. Pedro seguía gritando desesperado, pero nadie acudió en su ayuda. El lobo se comió a tres de sus ovejas sin que él pudiera hacer nada por evitarlo.\n" +
                "\n" +
                "Y así fue cómo el joven pastor se dio cuenta del error que había cometido burlándose de sus vecinos. Aprendió la lección y nunca más volvió a mentir ni a tomarle el pelo a nadie.');" +
                "\n" +
                "\n" +
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(14,14,' La moraleja de la película explica que el afán por el dinero y el ansia de poder no pueden luchar contra la fuerza del amor y la honestidad. Aladino fue un pobre ladronzuelo, pero es puro de corazón y humilde, puesto que no duda en ayudar a los demás. La película hace hincapié en que la nobleza de corazón cosecha frutos mucho mejores que la avaricia.','Hace mucho tiempo, en una ciudad china, vivió un joven de familia pobre llamado Aladino, que era bastante vago. Su padre quiso enseñarle su oficio, pues era sastre, pero Aladino prefería pasar el tiempo con sus amigos en las calles.\n" +
                "\n" +
                "Siendo Aladino un adolescente su padre murió. Su madre no sabía qué hacer para que el muchacho trabajara y ayudara en casa, pues ella sola no podía sacarlo adelante.\n" +
                "\n" +
                "Un día a Aladino se le acercó un hombre que decía ser su tío, hermano de su difunto padre. El hombre le dio dinero a Aladino para que se lo entregara a su madre pero ella desconfió de las intenciones de aquel extraño del que nunca había oído hablar.\n" +
                "\n" +
                "Al día siguiente, el extraño fue a cenar a casa de Aladino y su madre. Allí, el hombre decidió proponerle algo a Aladino.\n" +
                "\n" +
                "- Desde mañana tendrás un oficio. ¿Te gustaría tener tu propia tienda de trajes? -preguntó el hombre a Aladino.\n" +
                "- Claro, tío -dijo Aladino, seducido por la idea de tener su propio negocio.\n" +
                "- No se hable más. Mañana iremos a buscar una tienda para ti-dijo el tío. Y se marchó.\n" +
                "\n" +
                "Esto convenció a Aladino y a su madre de que aquel hombre era quien decía ser. ¿Por qué, si no, iba a ofrecerle aquella oportunidad?\n" +
                "\n" +
                "A la mañana siguiente Aladino se fue con su tío y caminaron juntos hasta una montaña, lejos de la ciudad. Fue entonces cuando supo quien era en realidad aquel hombre: un malvado brujo que necesitaba a Aladino para conseguir sus propósitos.\n" +
                "\n" +
                "El brujo dijo unas palabras mágicas y el suelo se abrió. Entonces, le dijo al joven Aladino:\n" +
                "\n" +
                "- Bajo esta montaña hay un tesoro para ti. Ponte este anillo, que ahuyentará tus miedos. Abajo encontrarás una losa: levántala mientras dices tu nombre. Tras ella encontrarás mucho oro, pero no debes tocar nada. Sigue adelante hasta un salón con una escalera de piedra. Sube y coge la lámpara que hay allí colgada diciendo tu nombre y vuelve con ella. De regreso podrás coger todo el oro que desees.\n" +
                "\n" +
                "Aladino hizo lo que le pidió el mago. Cuando cogió la lámpara la guardó entre sus ropas para poder coger algunos objetos de oro.\n" +
                "\n" +
                "Para salir le pidió a su tío ayuda, el cual le pidió que primero le diera la lámpara. Pero Aladino la tenía entre la ropa y no podía cogerla. El hombre insistía, pero Aladino no podía hacer otra cosa. Cansado de esperar, el brujo cerró la tierra, dejó a Aladino dentro y se marchó.\n" +
                "\n" +
                "Aladino lloró desconsolado, pues pensaba que iba a morir allí. Sin darse cuenta, frotó la lámpara. Al hacerlo, un genio salió del anillo que llevaba...\n" +
                "\n" +
                "- Soy tu esclavo -dijo el genio.- Ordena lo que desees y te lo concederé.\n" +
                "\n" +
                "Aladino no podría creer lo que veía. Pero, para comprobarlo, le pidió salir de allí y al momento estaba fuera. Aladino regresó a casa y escondió la lámpara, y no le contó a nadie lo ocurrido.\n" +
                "\n" +
                "Unos días después Aladino decidió vender la lámpara para comprar alimentos. Se puso a limpiarla para poder sacar más dinero por ella. Entonces el genio volvió a aparecer.\n" +
                "\n" +
                "- Eres mi amo, lo que desees te será concedido -dijo el genio.\n" +
                "- Quiero mucha comida – respondió Aladino.\n" +
                "\n" +
                "Al momento sus deseos se vieron cumplidos con creces: decenas de platos de oro llenos de comida. Cuando la madre lo vio se asustó, así que Aladino tuvo que contarle lo que ocurría con el genio de la lámpara.\n" +
                "\n" +
                "Gracias al genio, Aladino y su madre tuvieron comida para varios días y, vendiendo los platos donde había dejado la comida, consiguieron dinero para comer muchas semanas más.\n" +
                "\n" +
                "Una tarde Aladino oyó hablar de la hermosa hija del sultán. A Aladino le invadió la curiosidad y quiso conocerla, así que se escondió. Al verla pasar, el joven se enamoró de ella. Tal fue su enamoramiento que Aladino pidió a su madre que fuera al palacio a pedir la mano de la princesa.\n" +
                "\n" +
                "La madre se presentó en el palacio llevando como regalo algunas de las joyas que Aladino había sacado de la montaña y varios platos en los que el genio había dejado la comida. Pero nadie reparó en sus regalos, solo en sus pobres ropas, y no la dejaron pasar.\n" +
                "\n" +
                "Tras insistir varios días, al final la dejaron pasar, intrigados por lo que aquella mujer pretendía.\n" +
                "\n" +
                "Cuando la madre de Aladino pidió la mano de la princesa para su hijo el sultán se echó a reír, acompañado por su inseparable visir.\n" +
                "\n" +
                "Entonces, la mujer le entregó los regalos que llevaba.\n" +
                "\n" +
                "- Dame tres meses para demostrarte con un regalo mejor que mi hijo es digno de casarse con tu hija -dijo la madre de Aladino.\n" +
                "\n" +
                "Ese era justo el tiempo que faltaba para la boda que ya había pactado el sultán con el hijo del visir y la princesa. El sultán le dio de plazo a la madre de Aladino hasta entonces.\n" +
                "\n" +
                "La madre fue contenta a contarle a Aladino la buena noticia. Sin embargo, no pudo evitar advertir a su hijo que sospechaba del visir, pues no le parecía trigo limpio.\n" +
                "\n" +
                "Dos meses después, la madre de Aladino se sorprendió al ver que la boda de la princesa se había adelantado, y fue corriendo a contárselo a su hijo.\n" +
                "Aladino cogió la lámpara y la frotó. El genio apareció de nuevo y le dijo:\n" +
                "\n" +
                "- Eres mi amo, lo que desees te será concedido.\n" +
                "- Quiero que esta noche traigas a la princesa y a su esposo a mi casa cuando se retiren a su cuarto. A él déjalo paralizado en el baño hasta que amanezca. Luego los devolverás a palacio.\n" +
                "\n" +
                "Y así sucedió. Cuando la princesa y su esposo aparecieron en casa de Aladino se asustaron mucho. Entonces, Aladino se acercó a la princesa y le dijo:\n" +
                "\n" +
                "- No temas, no te sucederá nada. Yo te protegeré.\n" +
                "\n" +
                "A la mañana siguiente el genio los devolvió al palacio antes de que nadie notara su ausencia. Ella no contó nada a nadie, pero su padre se mostró preocupado por ella, pues no la veía dichosa. Él se lo contó a su padre, el visir, pero éste le prohibió contar esa historia para que no le tomaran por loco.\n" +
                "\n" +
                "Esa noche volvió a suceder lo mismo. El sultán, al ver que su hija seguía igual, exigió que le contara lo que sucedía. Ella se lo contó. Su padre enfureció y llamó al visir y a su hijo.\n" +
                "\n" +
                "El hijo del visir, que estaba asustado y no quería volver a pasar otra noche paralizado, le rogó a su padre que lo liberase de ese matrimonio. Pero su padre se negó.\n" +
                "\n" +
                "Sin embargo, cuando el visir confirmó que todo era verdad, el sultán anuló el matrimonio de su hija para no tener problemas.\n" +
                "\n" +
                "Al enterarse de la noticia, Aladino esperó el plazo que el sultán le había prometido , y envió a su madre para que le concediera la mano de la princesa.\n" +
                "\n" +
                "El sultán, que ya se había olvidado de Aladino, no sabía qué hacer para no faltar a su promesa. Así que siguió el consejo del visir y le pidió a Aladino algo imposible: un regalo de bodas que incluyera cuarenta platos de oro con gemas que deberían ser llevados por cuarenta esclavas acompañadas por cuarenta esclavos.\n" +
                "\n" +
                "Aladino no se asustó y fue a buscar su lámpara mágica y le pidió al genio lo que reclamaba el sultán. Cuando todo estuvo listo todos salieron hacia el palacio.\n" +
                "\n" +
                "El sultán quedó maravillado, pero el visir sospechaba algo. Mientras tanto, el sultán mandó preparar la boda para esa misma noche.\n" +
                "\n" +
                "Aladino volvió a frotar la lámpara para pedirle al genio que lo vistiera a él y a su madre de modo adecuado para la ceremonia, dejando maravillado a todo el mundo por su elegancia y la riqueza de sus ropajes.\n" +
                "\n" +
                "Tras la boda, Aladino le dijo al sultán que construiría un palacio nuevo para él y su esposa. Dicho esto, Aladino fue a su casa a frotar la lámpara, y le pidió al genio el palacio más lujoso visto jamás. El nuevo palacio sorprendió a todos. Pero el visir, muerto de envidia, seguía sospechando de Aladino.\n" +
                "\n" +
                "La lámpara de AladinoPara celebrar la boda, Aladino repartió miles de monedas de oro entre la gente de la ciudad, lo que le hizo ganarse el cariño y el respeto de todos.\n" +
                "\n" +
                "Mientras tanto, en África, el brujo que se había hecho pasar por tío de Aladino investigaba con sus trucos qué había sido del joven al que quiso engañar. Al descubrir que Aladino estaba vivo, que era rico y que se había casado con la hija del sultán se fue a buscarlo. Compró muchas lámparas y corrió la voz de que cambiaba las lámparas viejas por lámparas nuevas.\n" +
                "\n" +
                "Una sirvienta de la princesa, que lo oyó, le aconsejó que cambiara la de Aladino, que se veía vieja y desgastada. Ella no sabía nada del genio, así que le pareció una gran idea y ordenó a la sirvienta que hiciera el cambio. Aladino estaba de viaje, por lo que no pudo detenerla.\n" +
                "\n" +
                "El brujo, al apoderarse de la lámpara, la frotó y le pidió genio salió que trasladase el palacio entero con la princesa a su ciudad.\n" +
                "\n" +
                "A la mañana siguiente el sultán fue a visitar a su hija y se encontró con que ella y el palacio habían desaparecido. El sultán mandó a buscar a Aladino y lo condenó a muerte.\n" +
                "\n" +
                "La gente de la ciudad, al enterarse que matarían a Aladino, comenzó a amenazar al sultán con atacar y quemar el palacio si algo le sucedía a Aladino.El sultán lo perdonó por miedo, pero le dio un mes para que trajera de vuelta a su hija. De lo contrario, lo mataría sin importarle las amenazas de la gente.\n" +
                "\n" +
                "Aladino estaba desesperado ya que sin la lámpara no sabía qué hacer y no sabía qué había pasado. Entonces recordó su anillo mágico, lo frotó y apareció el genio.\n" +
                "\n" +
                "- Genio te suplico que me devuelvas a mi esposa y al palacio -pidió Aladino.\n" +
                "- Lo que me pides es imposible -respondió el genio-. Todo está en poder del brujo, que tiene la lámpara, y ella es que es más poderosa que el anillo.\n" +
                "- Entonces llévame al lugar donde está el palacio -dijo Aladino.\n" +
                "\n" +
                "Al llegar frente al palacio, esperó ver salir al brujo y trepó por una ventana al cuarto de su esposa. Ella lo abrazó feliz y le contó que el brujo quería casarse con ella. Aladino trazó un plan.\n" +
                "\n" +
                "-Querida, invita al brujo a cenar y dile que estás arrepentida, que te casarás con él. Entonces, aprovecha para envenenarlo para que duerma profundamente. Yo me esconderé y solucionaré todo esto.\n" +
                "\n" +
                "Y así fue. Aladino recuperó la lámpara y regresó con la princesa gracias al genio. Años después, Aladino se convirtió en el nuevo sultán, y reinó con éxito durante varias décadas.');"+
                "\n" +
                "\n" +
                "\n" +
                 "INSERT INTO MisCONTENIDOCUENTOS VALUES(15,15,'El cuento de Pinocho es principalmente una historia de desobediencia y mentira con la que se pretende enseñar a los más pequeños la importancia de los valores opuestos: la obediencia y la honestidad. La historia transcurre llena de complicaciones mientras Pinocho no deja de mentir, pero cambia radicalmente cuando éste modifica su comportamiento y empieza a ser honesto con su padre. De esta forma demuestra a los niños cómo siendo buenos y honestos las cosas salen siempre mejor.\n" +
                "\n" +
                "De la relación que Pinocho mantiene con Gepetto podemos extraer también la importancia del amor, capaz de darle fuerzas al muñeco para enfrentarse a todo tipo de peligros como por ejemplo la ballena o el esfuerzo de llevar a su padre cuando él ya no puede más. En este sentido podríamos hablar también de sacrificio, puesto que Pinocho acaba entregando su vida para salvar la de su padre.','Una noche, estaba el carpintero Gepetto tallando en su taller un muñeco de madera. Como siempre, se esforzó tanto en su trabajo que el resultado fue realmente extraordinario. No le faltaba detalle: sus piernas, sus brazos, su cuerpo y una simpática nariz putiaguda.\n" +
                "\n" +
                "- Ya estás listo. Aunque debería ponerte un nombre… ¡Ya sé! Como estás hecho de pino te llamaré Pinocho. - dijo el viejo carpintero.\n" +
                "\n" +
                "Lástima que sólo seas un muñeco y no puedas ser mi hijo, me encantaría que fueses un niño de verdad.\n" +
                "\n" +
                "Pero mientras Gepetto dormía llegó a la casa una invitada: el Hada Azul. Ésta había oído el deseo del anciano y estaba allí para hacerlo realidad. Cogió su varita mágica y le dijo a Pinocho:\n" +
                "\n" +
                "- Despierta Pinocho. Ahora puedes hablar y moverte como los demás. Pero tendrás que ser muy bueno si quieres convertirte en un niño de verdad - y tras decir esto el hada desapareció.\n" +
                "\n" +
                "Pinocho comenzó a moverse por el taller y escondido tras unos juguetes descubrió a un grillo.\n" +
                "\n" +
                "- Hola, ¿quien eres? Yo me llamo Pinocho. Puedes salir y jugar conmigo si quieres.\n" +
                "\n" +
                "El grillo tuvo un poco de miedo, pero acabó saliendo. Se hicieron rápidamente amigos y empezaron a jugar y a reír. Armaron tal estruendo que despertaron a Gepetto.\n" +
                "\n" +
                "Cuando vio que su sueño se había cumplido y Pinocho había cobrado vida lo abrazó con todas sus fuerzas y comenzó a reír.\n" +
                "\n" +
                "- ¡Qué alegría Pinocho! Haré de tí un niño bueno y aplicado. Aunque para eso deberías ir a la escuela… Sí, ya se. Irás mañana mismo como todos los niños. Espérame aquí que voy a comprarte un libro.\n" +
                "\n" +
                "El anciano salió de casa y regresó muy tarde. Incluso tuvo que vender su abrigo para comprar el libro al pequeño. Pero no le importó porque sólo deseaba lo mejor en el mundo para el que ahora era su hijo.\n" +
                "\n" +
                "Al día siguiente Pinocho iba camino de la escuela cuando se cruzó con un chico al que todos llamaban Espárrago porque era muy delgado.\n" +
                "\n" +
                "- ¿Vas a ir al colegio? ¡Pero si es aburridísimo! Vente conmigo a ver el teatro de marionetas. ¡Verás como allí si que te lo pasas bien!\n" +
                "\n" +
                "Pinocho no lo dudó y le dijo que sí a su nuevo amigo.\n" +
                "\n" +
                "- Pero Pinocho, ¿qué haces? - le dijo el grillo parlanchín, que escondido en el bolsillo de su chaqueta lo había oído todo - ¡Tu obligación es ir a la escuela! ¡Y es también el deseo de tu padre!\n" +
                "\n" +
                "Pero Pinocho no hizo caso de los consejos de su amigo y fue con Espárrago al teatro.\n" +
                "\n" +
                "La función tanto gustó a Pinocho que acabó subiéndose al escenario con el resto de las marionetas. La gente aplaudía y reía animádamente y Tragalumbre, el dueño del teatro, se percató enseguida de que Pinocho podría hacerle ganar mucho dinero.\n" +
                "\n" +
                "- No puedo quedarme señor - contestó Pinocho a Tragalumbre - Mi padre…\n" +
                "\n" +
                "Y antes de que pudiera acabar la frase lo cogió por el brazo, lo metió en una jaula y lo encerró con llave.\n" +
                "\n" +
                "El pobre empezó a llorar, tanto que el Hada Azul lo oyó y acudió en su ayuda para liberarlo.\n" +
                "\n" +
                "De vuelta a casa Pinocho encontró a Gepetto muy preocupado.\n" +
                "\n" +
                "- ¿Dónde estabas Pinocho?\n" +
                "- En la escuela padre… Pero luego la maestra me pidió que fuera a hacer un recado…\n" +
                "\n" +
                "Y en ese instante la nariz de Pinocho comenzó a crecer y a crecer sin que el pobre pudiera hacer nada.\n" +
                "\n" +
                "- ¡Debes decir la verdad! Le reprendió su amigo el grillo parlanchín.\n" +
                "\n" +
                "Pinocho confesó muy triste la verdad a su padre y le prometió no volver a mentir ni faltar tampoco a la escuela.\n" +
                "\n" +
                "Al día siguiente cuando se dirigía a la escuela junto con su amigo el grillo cuando se encontró a Espárrago escondido en un callejón.\n" +
                "\n" +
                "- ¿Qué haces aquí Espárrago?\n" +
                "- Esperar al carruaje que va al País de los juguetes. Es un lugar increíble, está lleno de golosinas y caramelos y no hay escuela ni nadie que te diga lo que tienes que hacer. ¡Hasta puedes pasarte el día entero jugando si quieres! ¿Por qué no vienes conmigo?\n" +
                "\n" +
                "Pinocho aceptó rápidamente y de nuevo volvió a desobedecer a su padre y a olvidar sus promesas. Su amigo el grillo trató de advertírselo, pero Pinocho no hizo caso alguno.\n" +
                "\n" +
                "- ¡No, Pinocho!. No es buena idea que vayas, créeme. Recuerda la promesa a tu padre.\n" +
                "\n" +
                "En el País de los juegos todo era estupendo. Había atracciones por todos lados, los niños corrían y reían, podían comer algodón de azúcar y chocolate… a Pinocho no se le ocurría un lugar mejor en el que estar. Pinocho pasó así días y días hasta que un día pasó junto a un espejo y se dio un gran susto.\n" +
                "\n" +
                "- ¡¡¿Pero qué es esto?!! - dijo tocándose la cabeza - ¡Me han salido orejas de burro!\n" +
                "\n" +
                "Corrió a contárselo a Espárrago y no pudo encontrarlo por ninguna parte. ¡En su lugar había un burro! Estaba tan asustado que quiso pedir ayuda y todo lo que fue capaz de hacer fue rebuznar. Afortunadamente su fiel amigo el grillo parlanchín seguía siendo un grillo así que pudo indicar a Pinocho la forma de salir de aquel lugar lo antes posible.\n" +
                "\n" +
                "Pinocho y el grillo caminaron durante días hasta llegar a casa y las orejas de burro terminaron por desaparecer. Pero cuando llegaron a casa de Gepetto la encontraron vacía.\n" +
                "\n" +
                "- ¡No está! ¡Mi padre no está! - decía Pinocho entre lágrimas\n" +
                "\n" +
                "Una paloma que pasaba por allí oyó a Pinocho.\n" +
                "\n" +
                "- Perdona pero, ¿tu padre se llama Gepetto tal vez?\n" +
                "- Sí, si. ¿Cómo lo sabes?\n" +
                "- Porque lo he visto en el mar. Iba en una barca y una enorme ballena se lo ha tragado.\n" +
                "- ¿Una ballena? ¡Rápido grillo, tenemos que ir en su búsqueda! Gracias paloma.\n" +
                "\n" +
                "Pinocho y el grillo llegaron a la playa y se subieron a una pequeña barca de madera. Anduvieron días a la deriva en el inmenso océano. De repente, les pareció divisar tierra a lo lejos, pero cuando estuvieron cerca se dieron cuenta de que no era tierra lo que veían sino la ballena que andaban buscando.\n" +
                "\n" +
                "PinochoDejaron que la ballena se los tragara y todo se quedó sumido en la más absoluta oscuridad. Pinocho comenzó a llamar a su padre a gritos pero nadie le contestaba. En el estómago de la ballena solo había silencio. Al cabo de un largo rato Pinocho vio una lucecita al fondo y le pareció escuchar una voz familiar.\n" +
                "\n" +
                "- ¿Pinocho? ¿Eres tu, Pinocho?- gritaba la voz\n" +
                "- ¡Es mi padre! Papá aquí, soy yo. ¡Estoy aquí!\n" +
                "\n" +
                "Por fin pudieron volver a abrazarse padre e hijo después de tanto tiempo. Estaban tan contentos que por un momento se olvidaron de que tenían que encontrar la forma de salir de allí.\n" +
                "\n" +
                "- Ya sé - dijo Pinocho - haremos fuego quemando una de las barcas y así la ballena estornudará y podremos salir.\n" +
                "\n" +
                "\n" +
                "El plan dio resultado, la ballena dio un tremendo estornudo y Gepetto, Pinocho y el grillo parlanchín salieron volando. Estaban a punto de alcanzar la playa cuando Pinocho vio como a su viejo padre le faltaban las fuerzas para continuar.\n" +
                "\n" +
                "- Agárrate a mi. Yo te llevaré\n" +
                "\n" +
                "Pinocho lo llevó a su espalda pero él también empezaba a estar cada vez más y más cansado. Cuando llegaron a la orilla su cuerpo de madera se rindió y quedó tendido boca abajo en el agua.\n" +
                "\n" +
                "- ¡Pinocho! ¡No, por favor! ¡No te vayas y me dejes aquí! - gritaba desconsolado Gepetto cogiendo a Pinocho entre sus brazos\n" +
                "\n" +
                "En ese momento apareció el Hada Azul.\n" +
                "\n" +
                "- Gepetto, no llores. Pinocho ha demostrado que aunque haya sido desobediente tiene buen corazón y te quiere mucho así que se merece convertirse un niño de verdad.\n" +
                "\n" +
                "De modo que el hada movió su varita y los ojos de Pinocho se abrieron de nuevo. Se había convertido en un niño de verdad.\n" +
                "\n" +
                "Pinocho, Gepetto y el grillo volvieron a casa y vivieron felices durante muchos muchos años.');"+
                "\n" +
                "\n" +
                 "INSERT INTO MisCONTENIDOCUENTOS VALUES(16,16,'La historia de Cenicienta es una historia de bondad. La muchacha demuestra su bondad tratando bien a sus hermanas cuando ellas nunca han sido condescendientes con ella y la lleva al extremo cuando estas le piden perdón y las perdona sin pensárselo ofreciéndoles su cariño incondicional.','Érase una vez un hombre bueno que tuvo la desgracia de quedar viudo al poco tiempo de haberse casado. Años después conoció a una mujer muy mala y arrogante, pero que pese a eso, logró enamorarle.\n" +
                "\n" +
                "Ambos se casaron y se fueron a vivir con sus hijas. La mujer tenía dos hijas tan arrogantes como ella, mientras que el hombre tenía una única hija dulce, buena y hermosa como ninguna otra. Desde el principio las dos hermanas y la madrastra hicieron la vida imposible a la muchacha. Le obligaban a llevar viejas y sucias ropas y a hacer todas las tareas de la casa. La pobre se pasaba el día barriendo el suelo, fregando los cacharros y haciendo las camas, y por si esto no fuese poco, hasta cuando descansaba sobre las cenizas de la chimenea se burlaban de ella.\n" +
                "\n" +
                "- ¡Cenicienta! ¡Cenicienta! ¡Mírala, otra vez va llena de cenizas!\n" +
                "\n" +
                "Pero a pesar de todo ella nunca se quejaba.\n" +
                "\n" +
                "Un día oyó a sus hermanas decir que iban a acudir al baile que daba el hijo del Rey. A Cenicienta le apeteció mucho ir, pero sabía que no estaba hecho para una muchacha como ella.\n" +
                "\n" +
                "Planchó los vestidos de sus hermanas, las ayudó a vestirse y peinarse y las despidió con tristeza. Cuando estuvo sola rompió a llorar de pena por no poder ir al baile. Entonces, apareció su hada madrina:\n" +
                "\n" +
                "- ¿Qué ocurre Cenicienta? ¿Por qué lloras de esa manera?\n" +
                "\n" +
                "- Porque me gustaría ir al baile como mis hermanas, pero no tengo forma.\n" +
                "\n" +
                "- Mmmm… creo que puedo solucionarlo, dijo esbozando una amplia sonrisa.\n" +
                "\n" +
                "Cenicienta recorrió la casa en busca de lo que le pidió su madrina: una calabaza, seis ratones, una rata y seis lagartos. Con un golpe de su varita los convirtió en un magnífico carruaje dorado tirado por seis corceles blancos, un gentil cochero y seis serviciales lacayos.\n" +
                "\n" +
                "- ¡Ah sí, se me olvidaba! - dijo el hada madrina.\n" +
                "\n" +
                "Y en un último golpe de varita convirtió sus harapos en un magnífico vestido de tisú de oro y plata y cubrió sus pies con unos delicados zapatitos de cristal.\n" +
                "\n" +
                "- Sólo una cosa más Cenicienta. Recuerda que el hechizo se romperá a las doce de la noche, por lo que debes volver antes.\n" +
                "\n" +
                "Cuando Cenicienta llegó al palacio se hizo un enorme silencio. Todos admiraban su belleza mientras se preguntaban quién era esa hermosa princesa. El príncipe no tardó en sacarla a bailar y desde el instante mismo en que pudo contemplar su belleza de cerca, no pudo dejarla de admirar.\n" +
                "\n" +
                "A Cenicienta le ocurría lo mismo y estaba tan a gusto que no se dio cuenta de que estaban dando las doce. Se levantó y salió corriendo de palacio. El príncipe, preocupado, salió corriendo también aunque no pudo alcanzarla. Tan sólo a uno de sus zapatos de cristal, que la joven perdió mientras corría.\n" +
                "\n" +
                "CenicientaDías después llegó a casa de Cenicienta un hombre desde palacio con el zapato de cristal. El príncipe le había dado orden de que se lo probaran todas las mujeres del reino hasta que encontrara a su propietaria. Así que se lo probaron las hermanastras, y aunque hicieron toda clase de esfuerzos, no lograron meter su pie en él. Cuando llegó el turno de Cenicienta se echaron a reír, y hasta dijeron que no hacía falta que se lo probara porque de ninguna forma podía ser ella la princesa que buscaban. Pero Cenicienta se lo probó y el zapatito le quedó perfecto.\n" +
                "\n" +
                "De modo que Cenicienta y el príncipe se casaron y fueron muy felices y la joven volvió a demostrar su bondad perdonando a sus hermanastras y casándolas con dos señores de la corte.')";


        String cuento17_20 ="INSERT INTO MisCONTENIDOCUENTOS VALUES(17,17,'Moraleja: en la vida hay que ser humildes y tener en cuenta que los objetivos se consiguen con paciencia, dedicación, constancia y el trabajo bien hecho. Siempre es mejor ir lento pero a paso firme y seguro. Y por supuesto, jamás menosprecies a alguien por ser más débil, porque a lo mejor un día te hace ver tus propias debilidades.','En el campo vivían una liebre y una tortuga. La liebre era muy veloz y se pasaba el día correteando de aquí para allá, mientras que la tortuga caminaba siempre con aspecto cansado, pues no en vano tenía que soportar el peso de su gran caparazón.\n" +
                "\n" +
                "A la liebre le hacía mucha gracia ver a la tortuga arrastrando sus gordas patas, mientras que a ella le bastaba un pequeño impulso para brincar con agilidad. Cuando se cruzaban, la liebre se reía de ella y solía hacer comentarios burlones que por supuesto, a la tortuga no le parecían nada bien.\n" +
                "\n" +
                "– ¡Espero que no tengas mucha prisa, amiga tortuga! ¡Ja, ja, ja! A ese paso no llegarás a tiempo a ninguna parte ¿Qué harás el día que tengas una emergencia? ¡Acelera, acelera!\n" +
                "\n" +
                "Un día, la tortuga se hartó de tal modo, que se enfrentó a la liebre.\n" +
                "\n" +
                "– Tú serás veloz como el viento, pero te aseguro que soy capaz de ganarte una carrera.\n" +
                "\n" +
                "– ¡Ja, ja, ja! ¡Ay que me parto de risa! ¡Pero si hasta una babosa es más rápida que tú! – contestó la liebre mofándose y riéndose a mandíbula batiente.\n" +
                "\n" +
                "– Si tan segura estás – insistió la tortuga – ¿Por qué no probamos?\n" +
                "\n" +
                "– ¡Cuando quieras! – respondió la liebre con chulería.\n" +
                "\n" +
                "– ¡Muy bien! Nos veremos mañana a esta misma hora junto al campo de girasoles ¿Te parece?\n" +
                "\n" +
                "– ¡Perfecto! – asintió la liebre guiñándole un ojo con cara de insolencia.\n" +
                "\n" +
                "La liebre dando saltitos y la tortuga con la misma tranquilidad de siempre, se fueron cada una por su lado.\n" +
                "\n" +
                "Al día siguiente ambas se reunieron en el lugar que habían convenido. Muchos animales asistieron como público, pues la noticia de tan curiosa prueba de atletismo había llegado hasta los confines del bosque. Una familia de gusanos, durante la noche, se había encargado de hacer surcos en la tierra para marcar la pista de competición. La zorra fue elegida  para marcar con unos palos las líneas de salida y de meta, mientras que un nervioso cuervo se preparó a conciencia para ser el árbitro. Cuando todo estuvo a punto y al grito de “Preparados, listos, ya”, la liebre y la tortuga comenzaron la carrera. La tortuga salió a paso lento, como era habitual en ella. La liebre, en cambio, salió disparada, pero viendo que le llevaba mucha ventaja, se paró a esperarla y de paso, se burló un poco de ella.\n" +
                "\n" +
                "– ¡Venga, tortuga, más deprisa, que me aburro! – gritó fingiendo un bostezo – ¡Como no corras más esto no tiene emoción para mí!\n" +
                "\n" +
                "La tortuga alcanzó a la liebre y ésta volvió a dar unos cuantos saltos para situarse unos metros más adelante. De nuevo la esperó y la tortuga tardó varios minutos en llegar hasta donde estaba, pues andaba muy despacito.\n" +
                "\n" +
                "– ¡Te lo dije, tortuga! Es imposible que un ser tan calmado como tú pueda competir con un animal tan ágil y deportista como yo.\n" +
                "\n" +
                "A lo largo del camino, la liebre fue parándose varias veces para esperar a la tortuga, convencida de que le bastaría correr un poquito en el último momento para llegar la primera. Pero algo sucedió…  A pocos metros de la meta, la liebre se quedó dormida de puro aburrimiento  así que la tortuga le adelantó y dando pasitos cortos pero seguros,  se situó en el primer puesto. Cuando la tortuga estaba a punto de cruzar la línea de meta, la liebre se despertó y echó a correr lo más rápido que pudo, pero ya no había nada que hacer. Vio con asombro e impotencia cómo la tortuga se alzaba con la victoria y era ovacionada por todos los animales del bosque.\n" +
                "\n" +
                "La liebre, por primera vez en su vida, se sintió avergonzada  y jamás volvió a reírse de la tortuga.');"+
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(18,18,'La fábula de “La cigarra y la hormiga” es una de esas historias que merece la pena compartir con los más pequeños de casa. Su autoría se le atribuye a Esopo, pero más tarde fue recreada por Jean de La Fontaine y Félix María Samaniego. La fábula cuenta la historia de una cigarra que pasa todo el verano cantando mientras la hormiga trabajaba intensamente para recopilar provisiones para el invierno. Un cuento que versa sobre la importancia de la previsión y el esfuerzo que, sin duda, viene como anillo al dedo para reflexionar sobre este tema con los niños.','Era un verano muy caluroso, probablemente uno de los más calientes de las últimas décadas.  Quizá por eso, la cigarra decidió dedicar las horas del día a cantar alegremente debajo de un árbol. No tenía ganas de trabajar, solo le apetecía disfrutar de sol y cantar, cantar y cantar. De manera que así pasaba sus días, uno tras otro.\n" +
                "\n" +
                "Uno de esos días pasó por allí una hormiga que llevaba a cuestas un grano de trigo muy grande, tan grande que apenas podía sostenerlo sobre su espalda. Al verla, la cigarra se burló de ella y le dijo:\n" +
                "\n" +
                "– ¿Adónde vas con tanto peso? ¡Con el buen día que hace y con tanto calor! Se está mucho mejor aquí, a la sombra, cantando y jugando. ¿Acaso no quieres divertirte?, se rió la cigarra.\n" +
                "\n" +
                "La hormiga se detuvo y miró a la cigarra, pero prefirió hacer caso omiso de sus comentarios y continuar su camino en silencio y fatigada por el esfuerzo. Así, pasó todo el verano, trabajando y almacenando provisiones para el invierno. Y cada vez que veía a la cigarra, ésta se reía y le cantaba alguna canción de aires burlones:\n" +
                "\n" +
                "– ¡Qué risa me dan las hormigas cuando van a trabajar! ¡Qué risa me dan las hormigas porque no pueden jugar!\n" +
                "\n" +
                " \n" +
                "Así pasó el verano y las temperaturas empezaron a bajar. En ese momento, la hormiga dejó de trabajar y se metió en su hormiguero, donde se encontraba calentita y tenía comida suficiente para pasar todo el invierno. Entonces, se dedicó a jugar y cantar.\n" +
                "\n" +
                "Sin embargo, el invierno encontró a la cigarra debajo del mismo árbol, sin casa y sin comida. No tenía nada para comer y estaba helada de frío. Fue entonces cuando se acordó de la hormiga y fue a llamar a su puerta.\n" +
                "\n" +
                "– Amiga hormiga, sé que tienes provisiones de sobra. ¿Puedes darme algo de comer y te lo devolveré cuando pueda?\n" +
                "\n" +
                "La hormiga le abrió la puerta y le respondió enfadada:\n" +
                "\n" +
                "– ¿Crees que voy a darte la comida que tanto me costó reunir? ¿Qué has hecho holgazana durante todo el verano?\n" +
                "\n" +
                "– Ya lo sabes, le respondió apenada la cigarra. A todo el que pasaba, yo le cantaba.\n" +
                "\n" +
                "– Pues ahora, yo como tú puedo cantar: ¡Qué risa me dan las hormigas cuando van a trabajar! ¡Qué risa me dan las hormigas porque no pueden jugar!\n" +
                "\n" +
                "Y dicho esto, le cerró la puerta a la cigarra. A partir de entonces, la cigarra aprendió a no reírse del trabajo de los demás y a esforzarse por conseguir lo que necesitaba.\n" +
                "');"+
                "INSERT INTO MisCONTENIDOCUENTOS VALUES(20,20,'La lección más importante que aprendemos en este cuento es que no importa los obstáculos que nos ponga la vida por delante, si nos esforzamos podemos superarlos. También nos enseña que todos somos únicos y valiosos, si confiamos en nosotros mismos.','Había una vez un matrimonio que quería tener hijos. Tras mucho tiempo esperándolo finalmente tuvieron uno pero cuando nació resultó ser un niño muy pequeño, tan pequeño como un granito de arroz, por eso decidieron llamarlo Garbancito.\n" +
                "\n" +
                "Fue pasando el tiempo y aunque Garbancito se hacía mayor, seguía siendo igual de pequeño. Sus padres estaban algo preocupados, pero en cambio a él eso no le importaba. A él le gustaba trabajar y ayudar a sus padres como hacían el resto de los niños.\n" +
                "\n" +
                "Un día la madre de Garbancito estaba haciendo un riquísimo arroz con conejo cuando se quedó sin azafrán.\n" +
                "- ¡Madre mía! ¿Y ahora qué hago yo?\n" +
                "\n" +
                "Garbancito, que estaba por allí cerca, le contestó de inmediato:\n" +
                "\n" +
                "- Yo iré a comprarlo mamá. No te preocupes\n" +
                "- ¿Pero cómo vas a ir tu? ¿Y si no te ven y te pisan?\n" +
                "- Tranquila mamá\n" +
                "- No no hijo mío, ya voy yo.\n" +
                "- Por favor mamá, deja que vaya. Iré cantando una canción para que todos me oigan y así no me pisen y volveré a casa con tu azafrán.\n" +
                "\n" +
                "Aunque la mamá de Garbancito se quedó preocupada, al final acabó dejando a su hijo que fuera.\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "- Toma esta moneda y ve a “Ca la Rojals” Y ten mucho cuidado de que no te pisen\n" +
                "\n" +
                "Garbancito se echó la moneda a la espalda y salió a la calle cantando:\n" +
                "\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "\n" +
                "Todo el mundo se daba la vuelta cuando oía a Garbancito, pero como era tan pequeño no se le veía debajo de la moneda y creían que era la moneda la que cantaba y andaba sola.\n" +
                "\n" +
                "Cuando el muchacho llegó a la tienda pidió el azafrán que le había encargado su madre.\n" +
                "\n" +
                "- Buenos días señora, quería un poquito de azafrán para el arroz con conejo que está preparando mi madre.\n" +
                "- ¿Cómo? No le he oído - contestó la tendera sin saber de dónde venía aquella vocecilla -\n" +
                "- Que quería un poquito de azafrán para el arroz con conejo que está preparando mi madre.\n" +
                "- Pero, ¿dónde está señor? No lo veo por ninguna parte...\n" +
                "- ¡Estoy aquí! - contestó Garbancito un poco enfadado\n" +
                "- ¡Ay! ¡Una moneda que habla!\n" +
                "- No soy una moneda, soy Garbancito y quería un poquito de azafrán para el arroz con conejo que está preparando mi madre.\n" +
                "- Uy si si claro, enseguida\n" +
                "\n" +
                "Garbancito salió de la tienda con el azafrán y volvió a entonar fuertemente su canción para que todo el mundo pudiera oírle.\n" +
                "\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "\n" +
                "\n" +
                "La madre de Garbancito se puso muy contenta al ver que su hijo había vuelto sano y salvo.\n" +
                "\n" +
                "- Gracias hijo mío. Eres un niño muy bueno\n" +
                "\n" +
                "Garbancito se sentía muy orgulloso de haber podido ayudar a su madre y quiso hacer lo mismo con su padre, que estaba trabajando en el huerto.\n" +
                "\n" +
                "- Mamá, ¿me dejas que ayude también a papá? Puedo llevarle la cesta del almuerzo que siempre le llevas tu…\n" +
                "- Ay no sé hijo, es muy grande\n" +
                "- Déjame intentarlo, ya verás como puedo\n" +
                "\n" +
                "Al final Garbancito, que era muy tozudo, se salió con la suya y salió empujando la cesta camino del huerto cantando su canción para evitar que lo p isasen.\n" +
                "\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "\n" +
                "Cuando le faltaba poco para llegar empezó a llover muy fuerte así que Garbancito se refugió debajo de una col que había ahí al lado.\n" +
                "\n" +
                "Entonces apareció por ahí un buey grande y pesado y muerto de hambre. El animal se había metido en el huerto buscando una col para comérsela. Pero no veía ninguna… hasta que dio con la de Garbancito. Abrió la boca y ¡aaaammm! Garbancito fue a parar a la tripa del buey.\n" +
                "\n" +
                "El padre de Garbancito se cansó de esperar a que le llevara su mujer el almuerzo y acabó por regresar a casa enfadado.\n" +
                "\n" +
                "Garbancito / El Patufet- ¿Se puede saber por qué nadie me ha llevado hoy mi almuerzo? - le dijo a su mujer cuando entró en casa\n" +
                "- ¡No me digas que no ha aparecido por allí Garbancito!\n" +
                "\n" +
                "La mujer le explicó que Garbancito había salido con la cesta hacia allí y al no saber qué le habría ocurrido salieron los dos preocupadisimos a buscarlo. Los vecinos del pueblo se unieron a ellos en cuanto los oyeron llamar a su hijo:\n" +
                "\n" +
                "- ¡Garbancito! ¿Dónde estás?\n" +
                "- ¡Garbancitoo!\n" +
                "- ¿Dónde estás Garbancito?\n" +
                "- ¡Garbancito!\n" +
                "\n" +
                "Hasta que al final una voz a lo lejos contestó débilmente\n" +
                "\n" +
                "- ¡Estoy aquí, en la tripa del buey donde no nieva ni llueve!\n" +
                "\n" +
                "Todos siguieron aquella voz hasta el buey y decidieron que lo mejor era hacer cosquillas en la nariz al animal para conseguir que estornudara. Así que cogieron una pluma, el animal estornudó y al final Garbancito salió disparado.\n" +
                "\n" +
                "El pequeño se abrazó muy contento a sus padres y juntos volvieron a casa para comerse el arroz con conejo cantando:\n" +
                "\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis\n" +
                "Pachín, pachín, pachán,\n" +
                "A Garbancito no lo piséis');";

        String cuentoMagoOz ="INSERT INTO MisCONTENIDOCUENTOS VALUES(19,19,'El cuento del Mago de Oz es un libro de literatura infantil publicado en 1900. Su autor es Lyman Frank Baum y la historia de la pequeña Dorothy es conocida en todo el mundo. Es el primer cuento que ambientado (al menos en parte) en los Estados Unidos (la historia original comienza en Kansas) ya que, hasta entonces, toda la literatura infantil estaba ambientada en Europa','Dorothy vivía con sus tíos en una hermosa casa de madera en medio del campo, era una región poco poblada y muy árida. Como único compañero de juego tenía a Totó, un perrito revoltoso e inteligente." +

                               "Un día un terrible tornado apareció de la nada y se tragó por completo la casa y el granero. Dorothy y Totó, que estaban jugando dentro, se asustaron mucho al notar como la casa se despegaba del suelo. Al asomarse a la ventana y ver aquella enorme casa volando en círculos por todo el terreno, no podían creerlo. La casa se mantuvo girando dos o tres veces en el aire, pero luego comenzó a volar en silencio, arrastrada por el viento…" +

                                 "Estuvieron así varios días, incrédulos sin poder dejar de mirar por la ventana, hasta que la casa comenzó a subir y subir, hasta el punto en que solo podían ver nubes." +

                                "Pasaron varios días más hasta que, una mañana, Totó y Dorothy se despertaron con un ruido de madera que crujía. La casa estaba aterrizando sobre un hermoso césped de un verde brillante. Dorothy ya no tenía miedo y, empujada por la curiosidad, comenzó a salir poco a poco para mirar a su alrededor." +

                               "No había rastro de sus tíos, de la granja, de los demás animales ni de los vecinos… ¿Cómo volverían a casa? ¿Estaban muy lejos? ¿Dónde estaban?" +

              "Dorothy decidió que había que aventurarse en la espesura del bosque para tratar de encontrar la forma de volver a su casa. Quizás un leñador les podría indicar el camino… Así que eso hizo, junto a su amigo Totó, comenzó a caminar bosque a través." +

                "Apenas habían recorrido unos metros cuando, en medio del bosque, la niña pudo divisar un extraño camino. Entre los arbustos y el césped cubierto de hojas, aparecían unas grandes baldosas amarillas, de un color parecido al oro, que se colocaban amontonadas: grandes, pequeñas y medianas, cuadradas y redondas, una a una iban conformando un serpenteante camino que se adentraba en el bosque." +

                               "Sin dudarlo, Dorothy comenzó a caminar sobre las baldosas, dando alegras saltos y canturreando; mientras que Totó, algo más prudente, olisqueaba bien ese curioso suelo." +
                                "Pasaron las horas sin ver a nadie. Cuando, a lo lejos, pudieron ver un espantapájaros que estaba justo al borde del camino. Se pararon a observarlo un rato y, para su sorpresa, el espantapájaros se quito el sombrero y dijo." +

                                "– ¡Buenas tardes!" +

                                "¡Dorothy casi se cae del susto! Por su parte, Totó comenzó a ladrar y gruñir. ¿Un espantapájaros que habla?" +

                                "– Perdona si te he asustado. ¿Tú también vas a ver al Mago de Oz?- preguntó el espantapájaros." +

                                "– ¿Quién es ese mago?- contestó Dorothy que aún no podía creer que estaba hablando con un espantapájaros de trapo." +

                                "– ¡Es el hombre más sabio y poderoso del mundo! Todo lo que deseas, él puede encontrarlo. Yo me dirijo a Oz para pedirle un cerebro, estoy cansado de tener la cabeza llena de paja." +

                                "Entonces, Dorothy supo que, si quería encontrar la forma de volver a su casa, aquel mago debía saber la forma de hacerlo. Decidió acompañar al espantapájaros, después de tener que separarle de Totó varias veces: en cuanto se descuidaba, el pequeño perro le mordía los tobillos de paja." +

                                "En el camino se encontraron con un hombre de hojalata que estaba sentado en una piedra poniendo caras raras." +

                                "– ¿Qué te sucede?- le preguntó Dorothy extrañada." +

                                "El hombre de hojalata, torció el labio y comenzó a hacer unos sonidos extraños que sonaban a lata hueca." +

                               "– Estoy triste- dijo. Había algo raro en su cara." +
                            "El espantapájaros, demostrando que en vez de cerebro tenía paja, dijo lo primero que pasó por su cabeza:" +

                                "– No pareces triste, pareces más bien asustado, feliz, enfadado, alegre, aliviado y cansado… ¡Todo a la vez!" +

                                "– Ese es mi problema- replicó el hombre de hojalata-. No tengo sentimientos, necesito un corazón para poder sentir de verdad." +

                               "Dorothy, Totó y el espantapájaros invitaron al hombre de hojalata a que les acompañara en busca del Mago de Oz. Así cada uno podría conseguir lo que quería." +

                               "De repente,  apareció un león en el camino. Todos se asustaron porque no se imaginaban que era el león más cobarde del mundo. Quería ser valiente, pero no sabía cómo hacerlo. ¡Hasta tenía miedo de su sombra!" +

                               "El león estaba en mitad del camino. Caminaba distraído por él, olisqueando el suelo y parándose para lamerse las patas. De pronto, giró la cabeza y se quedó petrificado  al ver a Dorothy, a Toto y a sus nuevos amigos que estaban totalmente quietos y con cara de miedo." +
                                "El asustadizo león pensó que algo terrible debía de haber entre los matorrales (justo detrás de él) y, por eso, aquellas personas tenían esas caras de miedo. El espantapájaros volvió a decir lo primero que le pasó por la cabeza." +

                               "– ¡No nos comas leoncito, no nos comas! Y si quieres comer, que no sea a mí. Soy de paja y no tengo buen sabor." +

                                "– ¿Comeros yooooo?- preguntó el león muy extrañado-. ¡Si pensaba que había una bestia detrás de mí que nos iba a comer a todos!" +

                                "La carcajada fue general, una confusión muy divertida." +

                                "– ¡Me siento alegre!- exclamaba el hombre de hojalata una y otra vez." +

                               "Pronto hicieron buenas migas con aquel león que les contó su problema para ser valiente. Así que juntos emprendieron el viaje al lejano reino de Oz para hacer sus peticiones al mago." +

                                "En dirección al castillo del mago, el paisaje se volvió cada vez más extraño y fascinante: curiosas flores y plantas gigantescas sonreían a los recién llegados. En un momento dado, en la cima de una montaña lejana, apareció un enorme castillo. ¡Allí vivía el Mago de Oz!" +

                                "¡Por fin estaban llegando! Sólo tenían que caminar por la larga avenida de baldosas amarillas hasta llegar al castillo y pedirle al mago que cumpliera sus deseos." +

                                "Cuando llegaron a la puerta, antes de llamar, se prepararon para encontrarse con el Mago de Oz: Dorothy se peinó los rizos y pasó la mano por Totó para peinarle también, el león sacudió el polvo de su melena, el espantapájaros comprobó que tenía el relleno bien apretado y el hombre de hojalata se echó unas gotitas de aceite en las rodillas para no hacer ruido al caminar." +

                               "Una vez que entraron, encontraron a un anciano con una tierna mirada en su cara. Dorothy le contó toda su historia y, después de escuchar sus peticiones, el Mago decidió cumplirlas, dándole a cada uno lo que realmente quería:" +
                               "Dorothy soñaba con abrazar a sus tíos de nuevo." +

                               "El hombre de hojalata quería tener un latido en el pecho que le hiciera sentir." +

                                "El león, tener el valor que se espera de él." +

                                "Y el espantapájaros quería tener inteligencia y no una cabeza llena de paja." +

                                "Totó también cumplió sus deseos : el Mago le concedió un enorme hueso inagotable para morder y relamerse una y otra vez." +

                               "Todos juntos celebraron que, pese al largo camino, habían conseguido lo que buscaban. La fiesta se alargó hasta muy tarde y Dorothy se quedó dormida abrazada a Totó." +

                                "Cuando despertó, estaba en su cama, en su casa y todo estaba en su sitio. Además, sus tíos le esperaban para desayunar. Dorothy se preguntaba si había soñado todo aquello hasta que al irse a calzar, vio que la suela de sus zapatos estaba teñida de amarillo. Fue a buscar a Totó que se encontraba en el jardín mordiendo un hueso gigantesco y, sin salir de su asombro, notó como unas cuantas briznas de paja caían de su cabeza. ');";


        String pruebaIngles ="INSERT INTO MisCONTENIDOCUENTOS VALUES(21,21,'The Story of Sindbad the Sailor has been told in many versions, with slight variations in title and detail. Sometimes his name is spelled differently: The Seven Voyages of Sinbad the Sailor. We''ve chosen Arabian Nights, Windermere Series, illustrated by Milo Winter (1914). This story was probably added to the original One Thousand and One Nights in the European translations, notably by Antoine Galland (1704 and 1717).','" +
                "Long ago, in the city of Baghdad, a young Sinbad lived with his father. Sinbad’s father was a rich merchant, but he died.\n" +
                "\n" +
                "Sinbad inherited a whole fortune. He was so rich, and he spent his money on rich clothes and incredible parties. But one day he was shocked … he did not have money! His purse was empty.\n" +
                "\n" +
                "Then, he decided sold his house. With money he bought silks and spices to sell them. A group of merchants invited Sinbad to join them. He jumped on board.\n" +
                "\n" +
                "The first adventure of Sinbad the sailor\n" +
                "After a days at sea, the sailors found a small island. They was cooking on the island with fire when the ground began to tremble.\n" +
                "\n" +
                "– The island is moving!- said a sailor.\n" +
                "\n" +
                "– It’s not an island… it’s a whale!- screamed scared Sinbad.\n" +
                "\n" +
                "\n" +
                "Many people drowned, but Sinbad was very lucky, and he could hold on to a chest that floated in the water. The next day, he landed on the shore of an island. There he met King Mahrajan. They became friends.\n" +
                "\n" +
                "A few days later, a ship arrived at the port. The ship was transporting silks and spices.\n" +
                "\n" +
                "– Oh… I had some silks like that- Sinbad said.\n" +
                "\n" +
                "– These silks belonged to a merchant called Sinbad- said the captain.\n" +
                "\n" +
                "– Sure? I am Sinbad!- cried him.\n" +
                "\n" +
                "Sinbad recovered his merchandise and he returned to Baghdad.\n" +
                "\n" +
                "\n" +
                "A fantastic second adventure of Sinbad the sailor\n" +
                "Sinbad bought more silks and spices to trade the next trip. He jump on board again. After a few days, they stopped at a desert island. But Sinbad fell asleep under a coconut tree. He woke in a panic… the ship had set sail without him!\n" +
                "\n" +
                "Sinbad climbed a tree and he could see a gigantic white egg. Then, he watched a enormous bird flew onto the egg and settled down to sleep.\n" +
                "\n" +
                "– It´s a roc! I have an idea- said Sinbad- I will use my turban.\n" +
                "\n" +
                "He unwound his turban, crept up to the enormous bird and tied himself to its leg. The bird woke up and took Sinbad flying above the clouds.\n" +
                "\n" +
                "Then, the roc dived down into a deep valley. Sinbad untied himself quickly. But he saw that he was surrounded by huge snakes. He was scared.\n" +
                "\n" +
                "Sinbad saw a lot of jewels, and on top of a cliff, some people who threw meat to the valley.\n" +
                "\n" +
                "– They want jewels- he thought- The jewels are embedded in the flesh…\n" +
                "\n" +
                "Quickly, he tied himself to a sheep. A roc swooped down and grabbed the seep. The enormous bird landed on a cliff. He gave them jewels in exchange for a ship bound for Baghdad.\n" +
                "\n" +
                "One travel more than Sinbad the sailor\n" +
                "Sinbad arrived home with a bag of jewels. He bought more silks and spices for sell and travel again on a ship. But there was an ambushed and an ugly men threw the merchants overboard. They washed onto a beach.\n" +
                "\n" +
                "The sailors explored the new shore and found a fearsome giant with a single eye. He ate humans. In fact, he ate a fat merchant.\n" +
                "\n" +
                "When the giant asleep, Sinbad said:\n" +
                "\n" +
                "– We can scape. We must build boats with firewood…\n" +
                "\n" +
                "They built some boats. When the giant woke up, Sinbad stuck a stick in the eye of the giant. They ran to the sea and escaped. The giant threw stones, but could not see them. They could return home.\n" +
                "\n" +
                "The fourth trip of Sinbad the sailor\n" +
                "Sinbad joined another merchant ship, but the ship was wrecked. Sinbad was lucky and he came to an island. There was a king who had a beautiful daughter. We became friend and months later, Sinbad and the beautiful princess were married.\n" +
                "\n" +
                "But on that island, when the husband or the wife died, the the one who was alive was also buried. He was scared. His beautiful wife died and Sinbad went down to the grave with her, with water and some breads.\n" +
                "\n" +
                "When he thought he was going to die, a bird a bird entered the cave. Sinbad followed him and found an exit. He run to the beach and saw a ship. He could returned to home.\n" +
                "\n" +
                "The fifth trip of Sinbad the sailor\n" +
                "Sinbad bought a new boat. He came to an island with another roc’s egg. Some sailors threw stones at the egg to see what happened.\n" +
                "\n" +
                "– Oh, no- said Sinbad- They are fools… the mother roc will want revenge!\n" +
                "\n" +
                "Then, a giant roc arrived. She destroyed the ship and threw stones at the sailors, but Sinbad could escaped. He found an old man who climbed on his back. The old man did not want to go down!\n" +
                "\n" +
                "Sinbad was the old man’s prisoner. But he was an idea. Sinbad picked grapes and made wine. When the old man drank the wine, he fell asleep, and Sinbad could escaped.\n" +
                "\n" +
                "A boat could take him to home. Sinbad took many coconuts from the island.\n" +
                "\n" +
                "Sixth trip of Sinbad the sailor\n" +
                "In the sixth trip, Sinbad managed to make a fortune. His ship sank, but he discovered a mountain full of jewels. He did not know how to get out of that cave, but he discovered an underground river.\n" +
                "\n" +
                "On a boat, he came to a valley. Some men took him to the king. The king fell in love with his adventures and decided to write them in a book.\n" +
                "\n" +
                "Later, Sinbad could returned home. He was very rich.\n" +
                "\n" +
                "The last adventure of Sinbad the sailor\n" +
                "Sinbad returned to the island of his friend king. But when we got back, some corsairs attacked them. Sinbad was sold as a slave. He should hunt elephants.\n" +
                "\n" +
                "One day, Sinbad fell on top of an elephant. The animal took him to the elephant cemetery. – I know- said Sinbad- You want me to take the tusks of dead elephants… So I will not have to kill elephants…\n" +
                "\n" +
                "Some years later, Sinbad got back home')";

        String pruebaIngles2Bremen="INSERT INTO MisCONTENIDOCUENTOS VALUES(22,22,'This amusing story by the Brothers Grimm is about four farm animals who are convinced they can earn a good living as musicians. Indeed they do, but it isn’t really the sweetness of their barking, braying, mewing, and cockle-doodle-doing, that earns them their supper – it’s more the terror of the sound they make!','A certain man had a donkey, which had carried the corn sacks to the mill loyally for many a long year. But his strength was going, and he was growing more and more unfit for work. His master began to wonder if it was worth his while by keeping this old donkey much longer.\n" +
                "\n" +
                "The donkey, seeing that no good wind was blowing, ran away and set out on the road to Bremen. There, he thought, I can surely be town musician.\n" +
                "\n" +
                "When he had walked some distance, he found a dog lying on the road, gasping like one who had run until he was tired. What are you gasping so for, you big fellow? Asked the donkey.\n" +
                "\n" +
                "Ah, replied the dog, as I am old, and grow weaker daily; I can no longer hunt. My master wanted to kill me, so I ran away, but now how am I to earn my bread?\n" +
                "\n" +
                "I’ll tell you what, said the donkey, I am going to Bremen, and shall be a town musician there, come with me and work also as a musician. I will play the lute, and you shall beat the kettledrum.\n" +
                "\n" +
                "Old cat joins town musicians.\n" +
                "The dog agreed, and so on they went. Not before long they came to a cat, sitting on the path with a face like three rainy days! Now then, old fluff and claws, what has gone so wrong with you? Asked the donkey.\n" +
                "\n" +
                "Who can be merry when his neck is in danger? Answered the cat. Because I am now getting old, my teeth are worn to stumps, and I prefer to sit by the fire and spin, rather than hunt about after mice. My mistress wanted to drown me, so I ran away. Now good advice is scarce. Where am I to go?\n" +
                "\n" +
                "Go with us to Bremen. You understand night music so you can be a town musician.\n" +
                "\n" +
                "\n" +
                "The cat thought well of it and decided to go with them. After this the three runaways came to a farmyard, where the cockerel was sitting upon the gate, cock-a-doodle-doing with all his might. Your cock-a-doodle-do goes through and through my skull, said the donkey. What is the matter?\n" +
                "\n" +
                "Guests are coming on Sunday and the housewife has no pity, said the cockerel, and has told the cook that she intends to eat me in the soup tomorrow, and this evening I am to have my head cut off. Now I am cock-a-doodle-doing at full pitch while I can.\n" +
                "\n" +
                "Ah you red-headed bird, said the donkey, you had better come away with us. We are going to Bremen, you can find something better than death everywhere. You have a good voice, and if we make music together it must have some quality!.\n" +
                "\n" +
                "The cockerel agreed to this plan, and all four went on together. They could not, however, reach the city of Bremen in one day, and in the evening they came to a forest where they meant to pass the night. The donkey and the dog laid themselves down under a large tree, the cat and cockerel settled themselves in the branches – but the cockerel flew right to the top, where he was most safe. Before he went to sleep, he called out to his companions that there must be a house not far off, for he saw a light. The donkey said: If so, we had better get up and go on, for the shelter here is bad. The dog thought that a few bones with some meat on would do him good too!\n" +
                "\n" +
                "So they moved further on, and soon saw the light shine brighter and grow larger, until they came to a well lit robber’s house. The donkey, as the biggest, went to the window and looked in: What do you see, my grey horse? Asked the cockerel. What do I see? Answered the donkey. A table covered with good things to eat and drink, and robbers sitting at it enjoying themselves.\n" +
                "\n" +
                "\n" +
                "That would be just the sort of thing for us, said the cockerel. Yes, yes. Ah, how I wish we were there! Said the donkey.\n" +
                "\n" +
                "Then the animals put their heads together and schemed how to best win an invitation to come inside and join the robbers at the table.\n" +
                "\n" +
                "Come, come my friends, said the donkey. We are musicians, so let us sing for our supper.\n" +
                "\n" +
                "They began to perform their music together: The donkey brayed, the dog barked, the cat mewed, and the cockerel cock-a-doodle-do’ed. Then they burst through the window into the room, so that the glass clattered! At this horrible din, the robbers sprang up, thinking no otherwise than a ghost had come in, and they fled in a great fright out into the forest. The four companions now sat down at the table, well content with what was left, and ate as if they were going to fast for a month.\n" +
                "\n" +
                "As soon as the four musicians had done, they put out the light, and each found a sleeping place according to his nature and to what suited him. The donkey laid himself down upon some straw in the yard, the dog behind the door, the cat upon the hearth near the warm ashes, and the cockerel perched himself upon a beam of the roof; and being tired from their long walk, they soon went to sleep.\n" +
                "\n" +
                "When it was past midnight, the robbers saw from afar that the light was no longer burning in their house. Appearing quiet, the captain said: We ought not to have let ourselves be frightened out of our wits, and ordered one of them to go and examine the house.\n" +
                "\n" +
                "The messenger finding all was still, went into the kitchen to light a candle, and taking the glistening fiery eyes of the cat for burning coals, he held the candle to them to light it. The cat did not understand what he meant to do, however, and flew in his face, spitting and scratching. He was dreadfully frightened, and ran to the back door, but the dog, who lay there sprang up and bit his leg. As he ran across the yard by the straw heap, the donkey gave him a smart kick with its hind foot. The cockerel too, who had been awakened by the noise, had become lively, and cried down from the beam, Cock-a-doodle-doo!\n" +
                "\n" +
                "Then the robber ran back as fast as he could to his captain and said: Ah, there is a horrible witch sitting in the house, who spat on me and scratched my face with her long claws; and by the door stands a man with a knife who stabbed me in the leg, and in the yard there lies a monster who beat me with a wooden club. Above, upon the roof, sits the judge, who called out: “Bring the rogue here to me! So I got away as well as I could.\n" +
                "\n" +
                "After this the robbers did not trust themselves in the house again; but it suited the four musicians of Bremen so well that they did not care to leave it anymore.')";
        String threeLittlePigsreplace ="Once upon a time there was an old mother pig who had three little pigs and not enough food to feed them. So when they were old enough, she sent them out into the world to seek their fortunes.\n" +
                "\n" +
                "The first little pig was very lazy. He didn't want to work at all and he built his house out of straw. The second little pig worked a little bit harder but he was somewhat lazy too and he built his house out of sticks. Then, they sang and danced and played together the rest of the day.\n" +
                "\n" +
                "The third little pig worked hard all day and built his house with bricks. It was a sturdy house complete with a fine fireplace and chimney. It looked like it could withstand the strongest winds.\n" +
                "\n" +
                "The next day, a wolf happened to pass by the lane where the three little pigs lived; and he saw the straw house, and he smelled the pig inside. He thought the pig would make a mighty fine meal and his mouth began to water.\n" +
                "\n" +
                "So he knocked on the door and said:\n" +
                "\n" +
                "  Little pig! Little pig!\n" +
                "  Let me in! Let me in!\n" +
                "But the little pig saw the wolf's big paws through the keyhole, so he answered back:\n" +
                "\n" +
                "  No! No! No! \n" +
                "  Not by the hairs on my chinny chin chin!\n" +
                "Three Little Pigs straw houseThen the wolf showed his teeth and said:\n" +
                "\n" +
                "  Then I'll huff \n" +
                "  and I'll puff \n" +
                "  and I'll blow your house down.\n" +
                "So he huffed and he puffed and he blew the house down! The wolf opened his jaws very wide and bit down as hard as he could, but the first little pig escaped and ran away to hide with the second little pig.\n" +
                "\n" +
                "The wolf continued down the lane and he passed by the second house made of sticks; and he saw the house, and he smelled the pigs inside, and his mouth began to water as he thought about the fine dinner they would make.\n" +
                "\n" +
                "So he knocked on the door and said:\n" +
                "\n" +
                "  Little pigs! Little pigs!\n" +
                "  Let me in! Let me in!\n" +
                "But the little pigs saw the wolf's pointy ears through the keyhole, so they answered back:\n" +
                "\n" +
                "  No! No! No!\n" +
                "  Not by the hairs on our chinny chin chin!\n" +
                "So the wolf showed his teeth and said:\n" +
                "\n" +
                "  Then I'll huff \n" +
                "  and I'll puff \n" +
                "  and I'll blow your house down!\n" +
                "So he huffed and he puffed and he blew the house down! The wolf was greedy and he tried to catch both pigs at once, but he was too greedy and got neither! His big jaws clamped down on nothing but air and the two little pigs scrambled away as fast as their little hooves would carry them.\n" +
                "\n" +
                "The wolf chased them down the lane and he almost caught them. But they made it to the brick house and slammed the door closed before the wolf could catch them. The three little pigs they were very frightened, they knew the wolf wanted to eat them. And that was very, very true. The wolf hadn't eaten all day and he had worked up a large appetite chasing the pigs around and now he could smell all three of them inside and he knew that the three little pigs would make a lovely feast.\n" +
                "\n" +
                "Three Little Pigs brick house\n" +
                "\n" +
                "So the wolf knocked on the door and said:\n" +
                "\n" +
                "  Little pigs! Little pigs!\n" +
                "  Let me in! Let me in!\n" +
                "But the little pigs saw the wolf's narrow eyes through the keyhole, so they answered back:\n" +
                "\n" +
                "  No! No! No! \n" +
                "  Not by the hairs on our chinny chin chin!\n" +
                "So the wolf showed his teeth and said:\n" +
                "\n" +
                "  Then I'll huff \n" +
                "  and I'll puff \n" +
                "  and I'll blow your house down.\n" +
                "Well! he huffed and he puffed. He puffed and he huffed. And he huffed, huffed, and he puffed, puffed; but he could not blow the house down. At last, he was so out of breath that he couldn't huff and he couldn't puff anymore. So he stopped to rest and thought a bit.\n" +
                "\n" +
                "But this was too much. The wolf danced about with rage and swore he would come down the chimney and eat up the little pig for his supper. But while he was climbing on to the roof the little pig made up a blazing fire and put on a big pot full of water to boil. Then, just as the wolf was coming down the chimney, the little piggy pulled off the lid, and plop! in fell the wolf into the scalding water.\n" +
                "\n" +
                "So the little piggy put on the cover again, boiled the wolf up, and the three little pigs ate him for supper.";


        String duck1="It was lovely summer weather in the country, and the golden corn, the green oats, and the haystacks piled up in the meadows looked beautiful. The stork walking about on his long red legs chattered in the Egyptian language, which he had learnt from his mother. The corn-fields and meadows were surrounded by large forests, in the midst of which were deep pools. It was, indeed, delightful to walk about in the country. In a sunny spot stood a pleasant old farm-house close by a deep river, and from the house down to the water side grew great burdock leaves, so high, that under the tallest of them a little child could stand upright. The spot was as wild as the centre of a thick wood. In this snug retreat sat a duck on her nest, watching for her young brood to hatch; she was beginning to get tired of her task, for the little ones were a long time coming out of their shells, and she seldom had any visitors. The other ducks liked much better to swim about in the river than to climb the slippery banks, and sit under a burdock leaf, to have a gossip with her. At length one shell cracked, and then another, and from each egg came a living creature that lifted its head and cried, \"Peep, peep.\" \"Quack, quack,\" said the mother, and then they all quacked as well as they could, and looked about them on every side at the large green leaves. Their mother allowed them to look as much as they liked, because green is good for the eyes. \"How large the world is,\" said the young ducks, when they found how much more room they now had than while they were inside the egg-shell. \"Do you imagine this is the whole world?\" asked the mother; \"Wait till you have seen the garden; it stretches far beyond that to the parson's field, but I have never ventured to such a distance. Are you all out?\" she continued, rising; \"No, I declare, the largest egg lies there still. I wonder how long this is to last, I am quite tired of it;\" and she seated herself again on the nest.\n" +
                "\n" +
                "\"Well, how are you getting on?\" asked an old duck, who paid her a visit.\n" +
                "\n" +
                "\"One egg is not hatched yet,\" said the duck, \"it will not break. But just look at all the others, are they not the prettiest little ducklings you ever saw? They are the image of their father, who is so unkind, he never comes to see.\"\n" +
                "\n" +
                "\"Let me see the egg that will not break,\" said the duck; \"I have no doubt it is a turkey's egg. I was persuaded to hatch some once, and after all my care and trouble with the young ones, they were afraid of the water. I quacked and clucked, but all to no purpose. I could not get them to venture in. Let me look at the egg. Yes, that is a turkey's egg; take my advice, leave it where it is and teach the other children to swim.\"\n" +
                "\n" +
                "\"I think I will sit on it a little while longer,\" said the duck; \"as I have sat so long already, a few days will be nothing.\"\n" +
                "\n" +
                "\"Please yourself,\" said the old duck, and she went away.\n" +
                "\n" +
                "At last the large egg broke, and a young one crept forth crying, \"Peep, peep.\" It was very large and ugly. The duck stared at it and exclaimed, \"It is very large and not at all like the others. I wonder if it really is a turkey. We shall soon find it out, however when we go to the water. It must go in, if I have to push it myself.\"\n" +
                "\n" +
                "On the next day the weather was delightful, and the sun shone brightly on the green burdock leaves, so the mother duck took her young brood down to the water, and jumped in with a splash. \"Quack, quack,\" cried she, and one after another the little ducklings jumped in. The water closed over their heads, but they came up again in an instant, and swam about quite prettily with their legs paddling under them as easily as possible, and the ugly duckling was also in the water swimming with them.\n" +
                "\n" +
                "\"Oh,\" said the mother, \"that is not a turkey; how well he uses his legs, and how upright he holds himself! He is my own child, and he is not so very ugly after all if you look at him properly. Quack, quack! come with me now, I will take you into grand society, and introduce you to the farmyard, but you must keep close to me or you may be trodden upon; and, above all, beware of the cat.\"\n" +
                "\n" +
                "When they reached the farmyard, there was a great disturbance, two families were fighting for an eel's head, which, after all, was carried off by the cat. \"See, children, that is the way of the world,\" said the mother duck, whetting her beak, for she would have liked the eel's head herself. \"Come, now, use your legs, and let me see how well you can behave. You must bow your heads prettily to that old duck yonder; she is the highest born of them all, and has Spanish blood, therefore, she is well off. Don't you see she has a red flag tied to her leg, which is something very grand, and a great honor for a duck; it shows that every one is anxious not to lose her, as she can be recognized both by man and beast. Come, now, don't turn your toes, a well-bred duckling spreads his feet wide apart, just like his father and mother, in this way; now bend your neck, and say 'quack.'\"\n" +
                "\n" +
                "The ducklings did as they were bid, but the other duck stared, and said, \"Look, here comes another brood, as if there were not enough of us already! and what a queer looking object one of them is; we don't want him here,\" and then one flew out and bit him in the neck.\n" +
                "\n" +
                "\"Let him alone,\" said the mother; \"he is not doing any harm.\"\n" +
                "\n" +
                "\"Yes, but he is so big and ugly,\" said the spiteful duck \"and therefore he must be turned out.\"\n" +
                "\n" +
                "\"The others are very pretty children,\" said the old duck, with the rag on her leg, \"all but that one; I wish his mother could improve him a little.\"\n" +
                "\n" +
                "\"That is impossible, your grace,\" replied the mother; \"he is not pretty; but he has a very good disposition, and swims as well or even better than the others. I think he will grow up pretty, and perhaps be smaller; he has remained too long in the egg, and therefore his figure is not properly formed;\" and then she stroked his neck and smoothed the feathers, saying, \"It is a drake, and therefore not of so much consequence. I think he will grow up strong, and able to take care of himself.\"\n" +
                "\n" +
                "\"The other ducklings are graceful enough,\" said the old duck. \"Now make yourself at home, and if you can find an eel's head, you can bring it to me.\"\n" +
                "\n" +
                "And so they made themselves comfortable; but the poor duckling, who had crept out of his shell last of all, and looked so ugly, was bitten and pushed and made fun of, not only by the ducks, but by all the poultry. \"He is too big,\" they all said, and the turkey cock, who had been born into the world with spurs, and fancied himself really an emperor, puffed himself out like a vessel in full sail, and flew at the duckling, and became quite red in the head with passion, so that the poor little thing did not know where to go, and was quite miserable because he was so ugly and laughed at by the whole farmyard. So it went on from day to day till it got worse and worse. The poor duckling was driven about by every one; even his brothers and sisters were unkind to him, and would say, \"Ah, you ugly creature, I wish the cat would get you,\" and his mother said she wished he had never been born. The ducks pecked him, the chickens beat him, and the girl who fed the poultry kicked him with her feet. So at last he ran away, frightening the little birds in the hedge as he flew over the palings.\n" +
                "\"They are afraid of me because I am ugly,\" he said. So he closed his eyes, and flew still farther, until he came out on a large moor, inhabited by wild ducks. Here he remained the whole night, feeling very tired and sorrowful.\n" +
                "\n" +
                "In the morning, when the wild ducks rose in the air, they stared at their new comrade. \"What sort of a duck are you?\" they all said, coming round him.\n" +
                "\n" +
                "He bowed to them, and was as polite as he could be, but he did not reply to their question. \"You are exceedingly ugly,\" said the wild ducks, \"but that will not matter if you do not want to marry one of our family.\"\n" +
                "\n" +
                "Poor thing! he had no thoughts of marriage; all he wanted was permission to lie among the rushes, and drink some of the water on the moor. After he had been on the moor two days, there came two wild geese, or rather goslings, for they had not been out of the egg long, and were very saucy. \"Listen, friend,\" said one of them to the duckling, \"you are so ugly, that we like you very well. Will you go with us, and become a bird of passage? Not far from here is another moor, in which there are some pretty wild geese, all unmarried. It is a chance for you to get a wife; you may be lucky, ugly as you are.\"\n" +
                "\n" +
                "\"Pop, pop,\" sounded in the air, and the two wild geese fell dead among the rushes, and the water was tinged with blood. \"Pop, pop,\" echoed far and wide in the distance, and whole flocks of wild geese rose up from the rushes. The sound continued from every direction, for the sportsmen surrounded the moor, and some were even seated on branches of trees, overlooking the rushes. The blue smoke from the guns rose like clouds over the dark trees, and as it floated away across the water, a number of sporting dogs bounded in among the rushes, which bent beneath them wherever they went. How they terrified the poor duckling! He turned away his head to hide it under his wing, and at the same moment a large terrible dog passed quite near him. His jaws were open, his tongue hung from his mouth, and his eyes glared fearfully. He thrust his nose close to the duckling, showing his sharp teeth, and then, \"splash, splash,\" he went into the water without touching him, \"Oh,\" sighed the duckling, \"how thankful I am for being so ugly; even a dog will not bite me.\" And so he lay quite still, while the shot rattled through the rushes, and gun after gun was fired over him. It was late in the day before all became quiet, but even then the poor young thing did not dare to move. He waited quietly for several hours, and then, after looking carefully around him, hastened away from the moor as fast as he could. He ran over field and meadow till a storm arose, and he could hardly struggle against it. Towards evening, he reached a poor little cottage that seemed ready to fall, and only remained standing because it could not decide on which side to fall first. The storm continued so violent, that the duckling could go no farther; he sat down by the cottage, and then he noticed that the door was not quite closed in consequence of one of the hinges having given way. There was therefore a narrow opening near the bottom large enough for him to slip through, which he did very quietly, and got a shelter for the night. A woman, a tom cat, and a hen lived in this cottage. The tom cat, whom the mistress called, \"My little son,\" was a great favorite; he could raise his back, and purr, and could even throw out sparks from his fur if it were stroked the wrong way. The hen had very short legs, so she was called \"Chickie short legs.\" She laid good eggs, and her mistress loved her as if she had been her own child. In the morning, the strange visitor was discovered, and the tom cat began to purr, and the hen to cluck.\n" +
                "\n" +
                "\"What is that noise about?\" said the old woman, looking round the room, but her sight was not very good; therefore, when she saw the duckling she thought it must be a fat duck, that had strayed from home. \"Oh what a prize!\" she exclaimed, \"I hope it is not a drake, for then I shall have some duck's eggs. I must wait and see.\" So the duckling was allowed to remain on trial for three weeks, but there were no eggs. Now the tom cat was the master of the house, and the hen was mistress, and they always said, \"We and the world,\" for they believed themselves to be half the world, and the better half too. The duckling thought that others might hold a different opinion on the subject, but the hen would not listen to such doubts. \"Can you lay eggs?\" she asked. \"No.\" \"Then have the goodness to hold your tongue.\" \"Can you raise your back, or purr, or throw out sparks?\" said the tom cat. \"No.\" \"Then you have no right to express an opinion when sensible people are speaking.\" So the duckling sat in a corner, feeling very low spirited, till the sunshine and the fresh air came into the room through the open door, and then he began to feel such a great longing for a swim on the water, that he could not help telling the hen.\n" +
                "\n" +
                "\"What an absurd idea,\" said the hen. \"You have nothing else to do, therefore you have foolish fancies. If you could purr or lay eggs, they would pass away.\"\n" +
                "\n" +
                "\"But it is so delightful to swim about on the water,\" said the duckling, \"and so refreshing to feel it close over your head, while you dive down to the bottom.\"\n" +
                "\n" +
                "\"Delightful, indeed!\" said the hen, \"why you must be crazy! Ask the cat, he is the cleverest animal I know, ask him how he would like to swim about on the water, or to dive under it, for I will not speak of my own opinion; ask our mistress, the old woman- there is no one in the world more clever than she is. Do you think she would like to swim, or to let the water close over her head?\"\n" +
                "\n" +
                "\"You don't understand me,\" said the duckling.\n" +
                "\n" +
                "\"We don't understand you? Who can understand you, I wonder? Do you consider yourself more clever than the cat, or the old woman? I will say nothing of myself. Don't imagine such nonsense, child, and thank your good fortune that you have been received here. Are you not in a warm room, and in society from which you may learn something. But you are a chatterer, and your company is not very agreeable. Believe me, I speak only for your own good. I may tell you unpleasant truths, but that is a proof of my friendship. I advise you, therefore, to lay eggs, and learn to purr as quickly as possible.\"\n" +
                "\n" +
                "\"I believe I must go out into the world again,\" said the duckling.\n" +
                "\n" +
                "\"Yes, do,\" said the hen. So the duckling left the cottage, and soon found water on which it could swim and dive, but was avoided by all other animals, because of its ugly appearance. Autumn came, and the leaves in the forest turned to orange and gold. then, as winter approached, the wind caught them as they fell and whirled them in the cold air. The clouds, heavy with hail and snow-flakes, hung low in the sky, and the raven stood on the ferns crying, \"Croak, croak.\" It made one shiver with cold to look at him. All this was very sad for the poor little duckling. One evening, just as the sun set amid radiant clouds, there came a large flock of beautiful birds out of the bushes. The duckling had never seen any like them before. They were swans, and they curved their graceful necks, while their soft plumage shown with dazzling whiteness. They uttered a singular cry, as they spread their glorious wings and flew away from those cold regions to warmer countries across the sea. As they mounted higher and higher in the air, the ugly little duckling felt quite a strange sensation as he watched them. He whirled himself in the water like a wheel, stretched out his neck towards them, and uttered a cry so strange that it frightened himself. Could he ever forget those beautiful, happy birds; and when at last they were out of his sight, he dived under the water, and rose again almost beside himself with excitement. He knew not the names of these birds, nor where they had flown, but he felt towards them as he had never felt for any other bird in the world. He was not envious of these beautiful creatures, but wished to be as lovely as they. Poor ugly creature, how gladly he would have lived even with the ducks had they only given him encouragement. The winter grew colder and colder; he was obliged to swim about on the water to keep it from freezing, but every night the space on which he swam became smaller and smaller. At length it froze so hard that the ice in the water crackled as he moved, and the duckling had to paddle with his legs as well as he could, to keep the space from closing up. He became exhausted at last, and lay still and helpless, frozen fast in the ice.\n" +
                "Early in the morning, a peasant, who was passing by, saw what had happened. He broke the ice in pieces with his wooden shoe, and carried the duckling home to his wife. The warmth revived the poor little creature; but when the children wanted to play with him, the duckling thought they would do him some harm; so he started up in terror, fluttered into the milk-pan, and splashed the milk about the room. Then the woman clapped her hands, which frightened him still more. He flew first into the butter-cask, then into the meal-tub, and out again. What a condition he was in! The woman screamed, and struck at him with the tongs; the children laughed and screamed, and tumbled over each other, in their efforts to catch him; but luckily he escaped. The door stood open; the poor creature could just manage to slip out among the bushes, and lie down quite exhausted in the newly fallen snow.\n" +
                "\n" +
                "It would be very sad, were I to relate all the misery and privations which the poor little duckling endured during the hard winter; but when it had passed, he found himself lying one morning in a moor, amongst the rushes. He felt the warm sun shining, and heard the lark singing, and saw that all around was beautiful spring. Then the young bird felt that his wings were strong, as he flapped them against his sides, and rose high into the air. They bore him onwards, until he found himself in a large garden, before he well knew how it had happened. The apple-trees were in full blossom, and the fragrant elders bent their long green branches down to the stream which wound round a smooth lawn. Everything looked beautiful, in the freshness of early spring. From a thicket close by came three beautiful white swans, rustling their feathers, and swimming lightly over the smooth water. The duckling remembered the lovely birds, and felt more strangely unhappy than ever.\n" +
                "\n" +
                "\"I will fly to those royal birds,\" he exclaimed, \"and they will kill me, because I am so ugly, and dare to approach them; but it does not matter: better be killed by them than pecked by the ducks, beaten by the hens, pushed about by the maiden who feeds the poultry, or starved with hunger in the winter.\"\n" +
                "\n" +
                "Then he flew to the water, and swam towards the beautiful swans. The moment they espied the stranger, they rushed to meet him with outstretched wings.\n" +
                "\n" +
                "\"Kill me,\" said the poor bird; and he bent his head down to the surface of the water, and awaited death.\n" +
                "\n" +
                "But what did he see in the clear stream below? His own image; no longer a dark, gray bird, ugly and disagreeable to look at, but a graceful and beautiful swan. To be born in a duck's nest, in a farmyard, is of no consequence to a bird, if it is hatched from a swan's egg. He now felt glad at having suffered sorrow and trouble, because it enabled him to enjoy so much better all the pleasure and happiness around him; for the great swans swam round the new-comer, and stroked his neck with their beaks, as a welcome.\n" +
                "\n" +
                "Into the garden presently came some little children, and threw bread and cake into the water.\n" +
                "\n" +
                "\"See,\" cried the youngest, \"there is a new one;\" and the rest were delighted, and ran to their father and mother, dancing and clapping their hands, and shouting joyously, \"There is another swan come; a new one has arrived.\"\n" +
                "\n" +
                "Then they threw more bread and cake into the water, and said, \"The new one is the most beautiful of all; he is so young and pretty.\" And the old swans bowed their heads before him.\n" +
                "\n" +
                "Then he felt quite ashamed, and hid his head under his wing; for he did not know what to do, he was so happy, and yet not at all proud. He had been persecuted and despised for his ugliness, and now he heard them say he was the most beautiful of all the birds. Even the elder-tree bent down its bows into the water before him, and the sun shone warm and bright. Then he rustled his feathers, curved his slender neck, and cried joyfully, from the depths of his heart, \"I never dreamed of such happiness as this, while I was an ugly duckling.";


        String duck2 =duck1.replace("'", "''");
      //  String duck3 =duck2.replace("!", "!!");
      //  String duck5 =duck3.replace(";", ".");

        String duck4= "INSERT INTO MisCONTENIDOCUENTOS VALUES(34,34,'The moral of The Ugly Duckling story is to accept people for their qualities, their values, their friendship, and their humility. Do not judge others because of how they look. Appearances are misleading, and it is always better to accept a person for their many good qualities than accept them based on physical looks.\n" +
                "\n" +
                "This endearing story helps cultivate good qualities in children at an early age. This tale is narrated by parents around the globe to their little children while tucking them into bed!','"+duck2+"')";


        String princ="Once upon a time there was a prince who wanted to marry a princess; but she would have to be a real princess. He travelled all over the world to find one, but nowhere could he get what he wanted. There were princesses enough, but it was difficult to find out whether they were real ones. There was always something about them that was not as it should be. So he came home again and was sad, for he would have liked very much to have a real princess.\n" +
                "\n" +
                "One evening a terrible storm came on; there was thunder and lightning, and the rain poured down in torrents. Suddenly a knocking was heard at the city gate, and the old king went to open it.\n" +
                "\n" +
                "It was a princess standing out there in front of the gate. But, good gracious! what a sight the rain and the wind had made her look. The water ran down from her hair and clothes; it ran down into the toes of her shoes and out again at the heels. And yet she said that she was a real princess.\n" +
                "\n" +
                "Well, we'll soon find that out, thought the old queen. But she said nothing, went into the bed-room, took all the bedding off the bedstead, and laid a pea on the bottom; then she took twenty mattresses and laid them on the pea, and then twenty eider-down beds on top of the mattresses.\n" +
                "\n" +
                "On this the princess had to lie all night. In the morning she was asked how she had slept.\n" +
                "\n" +
                "Oh, very badly! said she. I have scarcely closed my eyes all night. Heaven only knows what was in the bed, but I was lying on something hard, so that I am black and blue all over my body. It's horrible!\n" +
                "\n" +
                "Now they knew that she was a real princess because she had felt the pea right through the twenty mattresses and the twenty eider-down beds.\n" +
                "\n" +
                "Nobody but a real princess could be as sensitive as that.\n" +
                "\n" +
                "So the prince took her for his wife, for now he knew that he had a real princess; and the pea was put in the museum, where it may still be seen, if no one has stolen it.\n" +
                "\n" +
                "There, that is a true story.";

        String prin2 =princ.replace("'", "''");
       // String prin3 =prin2.replace("!", "!!");
        //String prin4 =prin3.replace(";", ".");


        String princessPee ="INSERT INTO MisCONTENIDOCUENTOS VALUES(38,38,'Talk about a rigorous royalty identity test (one that mattress)! Hans Christian Andersen offers his literary tale about a young lady who must prove her worthiness to marry a prince. She could have simply offered, I''ll sleep on it. This classic fairytale was first published by Andersen in 1835.','"+prin2+"')";



        String threeLittlePigs1=threeLittlePigsreplace.replace("'", "''");

        String threeLittlePigs="INSERT INTO MisCONTENIDOCUENTOS VALUES(33,33,'The story of The Three Little Pigs featured here has been adapted from different sources and from childhood memory. The primary sources are English Fairy Tales, retold by Flora Annie Steel (1922) with illustrations by L. Leslie Brooke from the 1904 version. This story is featured in our Favorite Fairy Tales and Children''s Stories.','"+threeLittlePigs1+"')";

        String bella1 ="There was once a queen who had no children, and it grieved her sorely. One winter's afternoon she was sitting by the window sewing when she pricked her finger, and three drops of blood fell on the snow. Then she thought to herself:\n" +
                "\n" +
                "\"Ah, what would I give to have a daughter with skin as white as snow and cheeks as red as blood.\"\n" +
                "\n" +
                "After a while a little daughter came to her with skin as white as snow and cheeks as red as blood. So they called her Snow White.\n" +
                "\n" +
                "But before Snow White had grown up, her mother, the Queen, died and her father married again, a most beautiful princess who was very vain of her beauty and jealous of all women who might be thought as beautiful as she was. And every morning she used to stand before her mirror and say:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "And the mirror always used to reply:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "The greatest beauty is thine own.\"\n" +
                "But Snow White grew fairer and fairer every year, till at last one day when the Queen in the morning spoke to her mirror and said:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "the mirror replied:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "Snow White's the fairest thou must own.\"\n" +
                "Then the Queen grew terribly jealous of Snow White and thought and thought how she could get rid of her, till at last she went to a hunter and engaged him for a large sum of money to take Snow White out into the forest and there kill her and bring back her heart.\n" +
                "\n" +
                "But when the hunter had taken Snow White out into the forest and thought to kill her, she was so beautiful that his heart failed him, and he let her go, telling her she must not, for his sake and for her own, return to the King's palace. Then he killed a deer and took back the heart to the Queen, telling her that it was the heart of Snow White.\n" +
                "\n" +
                "Snow White wandered on and on till she got through the forest and came to a mountain hut and knocked at the door, but she got no reply. She was so tired that she lifted up the latch and walked in, and there she saw three little beds and three little chairs and three little cupboards all ready for use. And she went up to the first bed and lay down upon it, but it was so hard that she couldn't rest; and then she went up to the second bed and lay down upon that, but that was so soft that she got too hot and couldn't go to sleep. So she tried the third bed, but that was neither too hard nor too soft, but suited her exactly; and she fell asleep there.\n" +
                "\n" +
                "In the evening the owners of the hut, who were three little dwarfs who earned their living by digging coal in the hills, came back to their home. And when they came in, after they had washed themselves, they went to their beds, and the first of them said:\n" +
                "\n" +
                "\"Somebody has been sleeping in my bed!\"\n" +
                "\n" +
                "And then the second one said:\n" +
                "\n" +
                "\"And somebody's been sleeping in my bed!\"\n" +
                "\n" +
                "And the third one called out in a shrill voice, for he was so excited:\n" +
                "\n" +
                "\"Somebody is sleeping in my bed, just look how beautiful she is!\"\n" +
                "\n" +
                "So they waited till she woke up, and asked her how she had come there, and she told them all that the hunter had said to her about the Queen wanting to slay her.\n" +
                "\n" +
                "Then the dwarfs asked her if she would be willing to stop with them and keep house for them; and she said that she would be delighted.\n" +
                "\n" +
                "Next morning the Queen went up as usual to her mirror, and called out:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "And the mirror answered as usual:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "Snow White's the fairest thou must own.\"\n" +
                "And the Queen knew that Snow White had not been slain. So she sent for the hunter and made him confess that he had let Snow White go; and she made him search about beyond the forest, till at last he brought back word to her that Snow White was dwelling in a little hut on the hill with some coal-miners.\n" +
                "\n" +
                "Then the Queen dressed herself up like an old woman, and, taking a poisoned comb with her, went back the next day to the hut where Snow White was living. Now the dwarfs had warned her not to open the door to anybody lest evil might befall her; and she found it very lonesome keeping always within doors.\n" +
                "\n" +
                "When the Queen, disguised as an old woman, came to the door of the house she knocked upon it with her stick, but Snow White called out from within:\n" +
                "\n" +
                "\"Who is there? Go away! I must not let anybody come in.\"\n" +
                "\n" +
                "\"All right,\" answered the Queen. \"If you can come to the window we can have a little chat there, and I can show you my wares.\"\n" +
                "\n" +
                "So when Snow White came to the window the Queen said:\n" +
                "\n" +
                "\"Oh, what beautiful black hair; you ought to have a comb to bind it up;\" and she showed her the comb that she had brought with her.\n" +
                "\n" +
                "But Snow White said:\n" +
                "\n" +
                "\"I have no money and cannot afford to buy so fine a comb.\"\n" +
                "\n" +
                "Then the Queen said:\n" +
                "\n" +
                "\"That is no matter; perhaps you have something golden that you can give me in exchange.\"\n" +
                "\n" +
                "And Snow White thought of a golden ring that her father had given to her, and offered to give it for the comb. The Queen took it and gave Snow White the comb and bade her good-bye, and went back to the palace.\n" +
                "\n" +
                "Snow White lost no time in going to the mirror, and binding up her hair and putting the comb into it. But it had scarcely been in her hair a few minutes when she fell down as if she were dead, and all the blood left her cheeks, and she was Snow White indeed.\n" +
                "\n" +
                "When the dwarfs came home that evening they were surprised to find that the table was not spread for them, and looking about they soon found Snow White lying upon the ground as if she were dead. But one of them listened to her heart and said: \"She lives! She lives!\"\n" +
                "\n" +
                "And they began to consider what caused Snow White to fall into such a swoon. They soon found the comb, and when they took it out Snow White soon opened her eyes and became as lively as she ever was before.\n" +
                "\n" +
                "Next morning the Queen went to the mirror on the wall and said to it:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "Then the mirror said as before:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "Snow White's the fairest thou must own.\"\n" +
                "Then the Queen knew that something had happened to the comb and that Snow White was still alive. So she dressed herself once more as an old woman and took with her a poisoned ribbon and went to the hut of the three dwarfs. And when she got there she knocked at the door, but Snow White called out:\n" +
                "\n" +
                "\"You cannot enter; I must not open the door.\"\n" +
                "\n" +
                "Then, as before, the Queen called out in reply:\n" +
                "\n" +
                "\"Then come to the window, and you can see my wares.\"\n" +
                "\n" +
                "When Snow White came to the window the Queen said:\n" +
                "\n" +
                "\"You are looking more beautiful than ever, but how unbecomingly you arrange your hair. Did you use that comb I gave you yesterday?\"\n" +
                "\n" +
                "\"Yes, indeed,\" said Snow White, \"and I fell into a swoon because of it; I am afraid there is something the matter with it.\"\n" +
                "\n" +
                "\"No, no, that cannot be,\" said the Queen; \"there must be some mistake. But if you cannot use the comb I will let you have this pretty ribbon instead,\" and she held out the poisoned ribbon. Snow White took it, and after the old woman, as she thought she was, had gone away, Snow White went to the mirror and tied up her hair with the piece of ribbon. But scarcely had she done so when she fell to the ground lifeless and lay there as if she were dead.\n" +
                "\n" +
                "That evening the dwarfs came home and found Snow White lying on the ground as if dead, but soon discovered the poisoned ribbon and untied it; and almost as soon as this was done Snow White revived again.\n" +
                "\n" +
                "Next morning the Queen went once more to the mirror on the wall, and called out:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "to which the mirror replied, without any change:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "Snow White's the fairest thou must own.\"\n" +
                "And the Queen recognized that once again her plans had failed, and Snow White was still alive. So she dressed herself once more and took with her a poisoned apple, which was so arranged that only one half of it was poisoned and the rest of it was left as before. And when the Queen got to the hut of the dwarfs she tried to open the door, but Snow White called out:\n" +
                "\n" +
                "\"You can't come in!\"\n" +
                "\n" +
                "\"Then I'll come to the window,\" said the Queen.\n" +
                "\n" +
                "\"Ah, you are the old lady that came twice before; you have not brought me good luck, each time something has befallen me.\"\n" +
                "\n" +
                "But the Queen said:\n" +
                "\n" +
                "\"I do not know how that can be; I only brought you something for your hair; perhaps you tied it too tight. To show you that I have no ill-will against you I have brought you this beautiful apple.\"\n" +
                "\n" +
                "\"But my guardians,\" said Snow White, \"told me that I must take nothing more from you.\"\n" +
                "\n" +
                "\"Oh, this is nothing to wear,\" said the Queen, \"this is something to eat. To show you that there can be no harm in it I will take half of it myself and you shall eat the other half.\"\n" +
                "\n" +
                "So she cut the apple in two and gave the poisoned half to Snow White. And the moment she had swallowed the first bite of it she fell down dead. Then the Queen slunk away and went back to the palace and went at once to her chamber and addressed the mirror on the wall:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "And this time the mirror answered, as it used to do:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "The greatest beauty is thine own.\"\n" +
                "Then the Queen knew that Snow White was dead at last, and that she was without a rival in beauty.\n" +
                "\n" +
                "When the dwarfs came home that night they found Snow White lying upon the ground quite dead, and could not find out what had happened or how they could cure her. But, though she seemed dead, Snow White kept her beautiful white skin and seemed more like a statue than a dead person. So the dwarfs had a glass coffer made, and put Snow White in and locked it up. And she remained there for days and days without changing the slightest, looking oh, so beautiful under the glass case.\n" +
                "\n" +
                "Now a great prince of the neighbouring country happened to be hunting near the hill of the dwarfs and called at their hut to get a glass of water. And when he came in he found nobody there but Snow White lying in her crystal coffer. And he fell at once in love with her and sat by her side till the dwarfs came home, and he asked them who she was. Then they told him her history, and he begged that he might carry the coffer away so that he might always have her near him. At first they would not do so. But he showed how much he loved her, so that they at last yielded, and he called for his men to carry the coffer home to his palace.\n" +
                "\n" +
                "And when the men commenced carrying the coffer down the mountain they jolted it so much that the piece of poisoned apple in Snow White's throat fell out, and she revived and opened her eyes and looked upon the Prince who was riding by her side. Then he ordered the coffer to be opened, and told her all that had happened. And he took her home to his castle and married her.\n" +
                "\n" +
                "After this happened the Queen once more came to her room and spoke to the mirror on the wall and said:\n" +
                "\n" +
                "\"Mirror, mirror, on the wall,\n" +
                "Who is the fairest of us all?\"\n" +
                "And the mirror this time said again:\n" +
                "\n" +
                "\"Queen, Queen, on thy throne,\n" +
                "Snow White's the fairest thou must own.\"\n" +
                "And the Queen was so enraged because she had not destroyed Snow White that she rushed to the window and threw herself out of it and died on the spot.";

        String bella2 =bella1.replace("'", "''");
       // String bella3 =bella2.replace("!", "!!");
       // String bella4 =bella3.replace(";", ".");
        String bellaDurmiente="INSERT INTO MisCONTENIDOCUENTOS VALUES(39,39,'One of the most important lessons it teaches is the danger of vanity. The evil queen wants Snow White dead because she cannot accept the fact she is not the most beautiful woman in the kingdom. But it is this vanity that destroys her at the end. The concept of real beauty is another theme discussed in this story.','"+bella2+"')";
       // pruebaContenidoIngles= pruebaIngles.replace("!", "");

        String mermaid ="Far out in the sea where the water is very deep, the Sea King ruled the undersea world.\n" +
                "\n" +
                "In the deepest spot of the sea was his castle. The walls were made of blue coral.  On the roof were shells that opened and closed when the water passed by. And that is where the Sea King lived with his mother and four daughters, each one born a year apart." +
                "The youngest of the four princesses was the Little Mermaid. She spent much of her time swimming to ships that had fallen to the bottom of the sea.  The ships held treasures from the world above! She would fill her arms and set up her collection here and there. All the while she would sing. As she did, fish circled around to hear her.  For the Little Mermaid’s voice was the most beautiful one under the sea.\n" +
                "\n" +
                "The girls knew that when they turned 15, they could swim up to the surface for the first time. It would be a long time that the Little Mermaid had to wait, as she was the youngest! So she made her grandmother tell her all about life up on land. Tales about ships and towns, and every bit of stories about humans that she knew." +
                "Soon the eldest sister turned 15.  She was the first to be allowed to rise up to the surface.  When she came back, she had many wonders to tell her sisters about!  She told about resting on soft white sand. High above was a deep blue sky with puffy white clouds.  Later the sun set, she said, and the whole sky turned gold and red. She had watched the birds fly high above her, dipping and making turns in the red and gold sky." +
                "When the next sister turned 15, it was winter.She told of icebergs floating in the sea and shining bright.  All the ships stayed far away from the icebergs, she said, as if in fear. But the icebergs did not seem lonely.  They were like friends, floating close to each other. \n" +
                "\n" +
                "When it was the third sister’s turn, she told about moving as close as she could to the gate of a town. She heard people call out, horses that went clip, clopping down the street. And even music that she had never heard before." +
                "All this the Little Mermaid heard with wonder.  It wasn’t fair that she had to wait the longest!  At last the day came when she turned 15, too. Now she could rise up over the surface and see for herself.  \n" +
                "\n" +
                "When she came up over the water, the Little Mermaid was next to a large ship. On the ship beautiful music was playing. Sailors were dancing on the deck. They were laughing and having a fine time. It must be a party! Now and then as the waves lifted up the Little Mermaid, she could see better.  A handsome young man stepped out on the deck. When he did, a hundred rockets rose in the air. The party was for him. Was it his birthday? She swam closer.\n" +
                "The men all seemed to like that young man.  When he spoke, the sailors would laugh. Sometimes they patted him on his back in joy. Once that made his crown fall off. The men laughed and picked it up. “A crown,” said the Little Mermaid.  “He must be a prince.”\n" +
                "\n" +
                "Suddenly, it became very dark and the wind picked up.  The sailors started to run about on deck.  They pulled down the sail. The ship dipped and swooped.  It rolled side to side, and up and down on the high waves.\n" +
                "\n" +
                "Then lightning.  Thunder.  A strong rainstorm hit.  The poor ship started to tip on the rough waves!  It was so dark that the Little Mermaid could see nothing.  Then lightning lit up the sky, and she could see the young prince on deck.  He seemed to be the only one still there! He was working hard to keep the ship afloat.  He was throwing ropes out to his men who had jumped. But then, all at once, the waves got very high and the ship started to tip over.  The Prince was flung to the side of the ship and thrown overboard! Down into the sea he fell.\n" +
                "\n" +
                "He dropped very fast.  What was the Little Mermaid to do?  She knew that human beings cannot live under the water. She dove deep and fast.  She reached out and was able to grab his shirt. Then she swam up to the surface as fast as she could.  At last she could pull his head above the water. There the two of them floated as the waves rose and fell.  By morning, the storm had passed. Yet the prince was as still as he had been all night. From far off the Little Mermaid saw tops of hills.  “Land!” she said.\n" +
                "\n" +
                "She swam to the shore, pulling him behind her.  It was not easy to pull the young man up onto dry sand, but she did it.  Was he dead? She sang a sad song. All of a sudden, the prince started to move.  “Oh! Are you all right?” she asked, and touched his forehead." +
                "Just then, she heard a group of girls come over.  At once, she dove into the sea and hid behind a rock.  They must not see her - a mermaid! The girls found the prince, who was now awake. They called for help and soon he was led off. The prince would never know that she had saved him.  The Little Mermaid sank into a deep gloom. When she went back home, her sisters wanted to know all about her trip.  But she was too sad to say anything.\n" +
                "\n" +
                "Days went by.  Then weeks. The sisters went to their grandmother for help.  The old woman went to her granddaughter. “Child, what is the matter?” she said.\n" +
                "\n" +
                "The Little Mermaid cried out, “Grandmother, I will never be happy again!” She told about meeting the prince and saving him.  Then having to leave him behind. “Unless I can somehow walk on land and be with that young man, I will be sad for the rest of my days!”  \n" +
                "\n" +
                "“My dear,” said the grandmother, “you know as well as I do that it is not possible for a mermaid to walk on two legs!  Why, the only one who can do anything like that is the Sea Witch. But of course it is much too dangerous to go to her.”\n" +
                "\n" +
                "The Sea Witch!  Before she knew it, the Little Mermaid was headed to the far corner of the sea, where the Sea Witch lived." +
                "“This is no problem,” said the Sea Witch when the Little Mermaid told her what she needed. “I fix problems much harder than this.  Why, to have legs all you need to do is to drink my potion.” Then she turned to face the girl. “But I don’t just give it away, you understand.”\n" +
                "\n" +
                "“Oh!” said the Little Mermaid.  “What then is your price?” In her heart, she felt a lift.  So there was a way she could have two legs and be with the prince after all!  \n" +
                "\n" +
                "“Oh, not too much,” said the Sea Witch.  “For one, you must give up your voice.”\n" +
                "\n" +
                "“My voice?” said the Little Mermaid.  She knew her voice is what everyone loved about her the best.\n" +
                "\n" +
                "“You don’t need it,” said the Sea Witch.  “Chitter, chatter, what a waste of time! But know this, little pretty.  If the prince marries someone else, the next day you must die. And your voice will stay with me forever.  But then again, who knows? He might choose YOU....”\n" +
                "\n" +
                "The Little Mermaid’s heart leaped.  \n" +
                "\n" +
                "The Sea Witch held out a glass with the green potion.  “So!” she said. “What are you going to do? Make up your mind!  I don’t have all day.”" +
                "The Little Mermaid took the potion and drank it.  At once she felt dizzy and in pain, as if a sword was being passed through her body. She spun and jerked about, then fell.  When she awoke, she was on the same dry land as when she had rescued the prince. Lifting up her head, she could see that her dream had come true.  Where her tail had been, she had two human legs!" +
                "“Say, Miss, are you in trouble?”  It was none other than the prince! She tried to say something but no words came out of her mouth.  “Can you not speak?” said he. She shook her head “no.” “Oh! Well then, let me take you to the castle.  You can clean up there and get some dry clothes to wear.”" +
                "You can be sure the Little Mermaid was very happy to join the prince at the castle!  At first, walking on her two legs was shaky. But soon she got the hang of it. That night, the prince showed her around the castle rooms.  He would point to a portrait and tell her all about the person. When he said something funny, they laughed together. When the story was sad, her kind eyes told him that she knew why and she felt sad, too.\n" +
                "\n" +
                "The next day was a royal party.  The prince had not been not looking forward to going to it. Hours of standing with finely-dressed people who talk and talk and have nothing to say!  He asked the Little Mermaid if she might come with him. She nodded a big “yes”! That day, with the Little Mermaid by his side, the prince felt glad.  Sometimes he would make a comment in a low voice to her. And by her eyes and face, he knew that she understood.\n" +
                "\n" +
                "After that, the prince wanted the Little Mermaid by his side every day.  He thought he could even fall in love with her. But he still held out hope to marry the one with the lovely voice he remembered from when he had been rescued.  Of course, it could not be his wonderful new friend who was not able to talk, let alone sing." +
                "The King called for his son one day.  “Son,” he said, “your mother and I have made a decision.  It is time that you took a bride. Lucky for you that we already picked one out for you.”\n" +
                "\n" +
                "“What!?” said the prince.  He only wanted to marry the woman with the beautiful voice that he remembered.  “Who is she?”\n" +
                "\n" +
                "“A princess from a nearby land.  Tonight she is coming with her parents.  We will make the wedding plans.”\n" +
                "\n" +
                "The prince was crushed.  And the Little Mermaid felt fear.  She knew what would happen to her the day after the prince married someone else!\n" +
                "\n" +
                "That night her troubles got even worse.  What the Little Mermaid did not know was that the Sea Witch had put her voice into this princess.  She was a stuck-up princess who thought only of herself. Yet when she spoke, it was the Little Mermaid’s voice that came out! The prince was stunned. He asked the princess to sing. It was the Little Mermaid’s voice that filled the room. The prince could not believe his luck!  At last, he could marry the woman he had longed for all this time! When he shared his joy with the Little Mermaid, she tried to show that she was happy for him.  But gloom filled her heart.\n" +
                "\n" +
                "The next morning at dawn, the Little Mermaid went to the sea. Her sisters, worried since they had not heard from her, rose above the water to see how she was.  Their youngest sister let them know the trouble she was in. The prince’s wedding was going to take place the very next day! And the day after that she must die. The sisters said not to worry, that they had an idea!  They told her to come back to the shore later that night. Then they dove back into the sea.\n" +
                "\n" +
                "That night, the Little Mermaid came back to the shore as she was told to do.  The three sisters rose up again. Gone was their beautiful long hair. For they had cut it all off to give to the Sea Witch in exchange for a knife.  With the knife, the Little Mermaid must kill the princess that very night. Then the wedding could not take place and she could return to the sea and be with her family.  She took the knife for she knew how much they had done for her in love. But in her heart she knew she was not going to kill the princess.\n" +
                "\n" +
                "The wedding day had arrived.  The Little Mermaid stepped up to the wedding ship with the other guests.  The wedding would take place at sunset.\n" +
                "\n" +
                "In the meantime, the three sisters had returned home.  They were met with an angry father. “Where is your sister?” the Sea King shouted. “Where have you all been?”\n" +
                "\n" +
                "They told the father the trouble their youngest sister was in. The father swam up to the wedding ship.  He saw the prince and princess getting ready to marry. He knew that his daughter did not use the knife the night before.  \n" +
                "\n" +
                "At once, the Sea King rushed to see the Sea Witch.  She laughed. She said there was only one way to save his youngest daughter from her fate.  If he would just hand over his scepter to her, the Little Mermaid could be saved. With the scepter in her hand, the Sea Witch would rule the underworld kingdom!  The Sea King took a deep breath. What else could he do? So, he agreed.\n" +
                "\n" +
                "The Sea Witch grabbed the scepter and laughed in glee.  She rushed to the wedding ship to see her victory. The Little Mermaid saw the Sea Witch rise out of the sea.  She saw that with the scepter, the Sea Witch had become a huge sea monster. Tentacles were twisting out from all over her body like an octopus.  The Little Mermaid knew she must protect the prince and even his new bride. So she took out the knife. Just then, one of the Sea Witches tentacles reached out and lifted the Little Mermaid right off the ship!  “This is the end for you!” crowed the Sea Witch.\n" +
                "\n" +
                "Before the Little Mermaid knew it, she was wrapped up by the tentacle.  She was spun to the very chest of the Sea Witch. And the knife she was holding – the Sea Witch’s very own knife – she used it and dove it deep into the chest of the monster.\n" +
                "\n" +
                "The Sea Witch reeled back in pain and the Little Mermaid was freed. On the ship, the guests ran around in fear.  The prince shot arrow after arrow at the monster.  Finally, the Sea Witch dropped down under the water.  As she fell, the Little Mermaid’s voice was let go, and it returned to her.    \n" +
                "\n" +
                "The princess then shouted in a gruff harsh voice, “What a lousy kingdom this is!  You can’t even have a proper wedding!” The prince heard the princess and knew that she was not who he thought she was.  Then the Little Mermaid started to sing. The prince knew that the voice he remembered belonged to the very one he had grown to love.\n" +
                "\n" +
                "The angry princess stormed off the wedding ship.  And her family followed close behind.\n" +
                "\n" +
                "When the Sea King arrived, the scepter was floating in the sea, as if it were waiting for him.  With a sweep of his arm, it was his again.\n" +
                "\n" +
                "“Well!” said the Sea King.  “I see my daughter is in good hands.” and, with a wave of his scepter, he lifted the Little Mermaid back onto the ship.\n" +
                "\n" +
                "The prince put his arms around her. “Now I know it was you all along!” said the prince.  “Will you marry me?” The Little Mermaid had her voice back now.  But with all the happiness in her heart, she could not manage to speak. So she nodded “yes” with a warm smile.  And a wedding on board ship took place after all.";

        String mermaid1 = mermaid.replace("'", "''");
       // String mermaid2 = mermaid1.replace("!", "!!");
       // String mermaid3 = mermaid2.replace(";", ".");
        String mermaidGood="INSERT INTO MisCONTENIDOCUENTOS VALUES(40,40,'The Little Mermaid (1837) is one of Hans Christian Andersen''s most beloved fairy tales. It is about a mermaid willing to give up her life in the sea and immortality in exchange for a human soul. We feature it in our Fairy Tales Guide.','"+mermaid1+"')";

        String rapunzel="There were once a man and a woman who had long in vain wished for a child. At length the woman hoped that God was about to grant her desire. These people had a little window at the back of their house from which a splendid garden could be seen, which was full of the most beautiful flowers and herbs. It was, however, surrounded by a high wall, and no one dared to go into it because it belonged to an enchantress, who had great power and was dreaded by all the world. One day the woman was standing by this window and looking down into the garden, when she saw a bed which was planted with the most beautiful rampion (rapunzel), and it looked so fresh and green that she longed for it, and had the greatest desire to eat some. This desire increased every day, and as she knew that she could not get any of it, she quite pined away, and looked pale and miserable. Then her husband was alarmed, and asked, \"What aileth thee, dear wife?\" \"Ah,\" she replied, \"if I can't get some of the rampion, which is in the garden behind our house, to eat, I shall die.\" The man, who loved her, thought, \"Sooner than let thy wife die, bring her some of the rampion thyself, let it cost thee what it will.\" In the twilight of the evening, he clambered down over the wall into the garden of the enchantress, hastily clutched a handful of rampion, and took it to his wife. She at once made herself a salad of it, and ate it with much relish. She, however, liked it so much—-so very much, that the next day she longed for it three times as much as before. If he was to have any rest, her husband must once more descend into the garden. In the gloom of evening, therefore, he let himself down again; but when he had clambered down the wall he was terribly afraid, for he saw the enchantress standing before him. \"How canst thou dare,\" said she with angry look, \"to descend into my garden and steal my rampion like a thief? Thou shalt suffer for it!\" \"Ah,\" answered he, \"let mercy take the place of justice, I only made up my mind to do it out of necessity. My wife saw your rampion from the window, and felt such a longing for it that she would have died if she had not got some to eat.\" Then the enchantress allowed her anger to be softened, and said to him, \"If the case be as thou sayest, I will allow thee to take away with thee as much rampion as thou wilt, only I make one condition, thou must give me the child which thy wife will bring into the world; it shall be well treated, and I will care for it like a mother.\" The man in his terror consented to everything, and when the woman was brought to bed, the enchantress appeared at once, gave the child the name of Rapunzel, and took it away with her.\n" +
                "\n" +
                "Rapunzel grew into the most beautiful child beneath the sun. When she was twelve years old, the enchantress shut her into a tower, which lay in a forest, and had neither stairs nor door, but quite at the top was a little window. When the enchantress wanted to go in, she placed herself beneath it and cried,\n" +
                "\n" +
                "\"Rapunzel, Rapunzel,\n" +
                "Let down your hair to me.\"\n" +
                "\n" +
                "Rapunzel had magnificent long hair, fine as spun gold, and when she heard the voice of the enchantress she unfastened her braided tresses, wound them round one of the hooks of the window above, and then the hair fell twenty ells down, and the enchantress climbed up by it.\n" +
                "\n" +
                "After a year or two, it came to pass that the King's son rode through the forest and went by the tower. Then he heard a song, which was so charming that he stood still and listened. This was Rapunzel, who in her solitude passed her time in letting her sweet voice resound. The King's son wanted to climb up to her, and looked for the door of the tower, but none was to be found. He rode home, but the singing had so deeply touched his heart, that every day he went out into the forest and listened to it. Once when he was thus standing behind a tree, he saw that an enchantress came there, and he heard how she cried,\n" +
                "\n" +
                "\"Rapunzel, Rapunzel,\n" +
                "Let down your hair.\"\n" +
                "\n" +
                "Then Rapunzel let down the braids of her hair, and the enchantress climbed up to her. \"If that is the ladder by which one mounts, I will for once try my fortune,\" said he, and the next day when it began to grow dark, he went to the tower and cried,\n" +
                "\n" +
                "\"Rapunzel, Rapunzel,\n" +
                "Let down your hair.\"\n" +
                "\n" +
                "Immediately the hair fell down and the King's son climbed up.\n" +
                "\n" +
                "At first Rapunzel was terribly frightened when a man such as her eyes had never yet beheld, came to her; but the King's son began to talk to her quite like a friend, and told her that his heart had been so stirred that it had let him have no rest, and he had been forced to see her. Then Rapunzel lost her fear, and when he asked her if she would take him for her husband, and she saw that he was young and handsome, she thought, \"He will love me more than old Dame Gothel does;\" and she said yes, and laid her hand in his. She said, \"I will willingly go away with thee, but I do not know how to get down. Bring with thee a skein of silk every time that thou comest, and I will weave a ladder with it, and when that is ready I will descend, and thou wilt take me on thy horse.\" They agreed that until that time he should come to her every evening, for the old woman came by day. The enchantress remarked nothing of this, until once Rapunzel said to her, \"Tell me, Dame Gothel, how it happens that you are so much heavier for me to draw up than the young King's son—-he is with me in a moment.\" \"Ah! thou wicked child,\" cried the enchantress \"What do I hear thee say! I thought I had separated thee from all the world, and yet thou hast deceived me.\" In her anger she clutched Rapunzel's beautiful tresses, wrapped them twice round her left hand, seized a pair of scissors with the right, and snip, snap, they were cut off, and the lovely braids lay on the ground. And she was so pitiless that she took poor Rapunzel into a desert where she had to live in great grief and misery.\n" +
                "\n" +
                "On the same day, however, that she cast out Rapunzel, the enchantress in the evening fastened the braids of hair which she had cut off, to the hook of the window, and when the King's son came and cried,\n" +
                "\n" +
                "\"Rapunzel, Rapunzel,\n" +
                "Let down your hair,\"\n" +
                "\n" +
                "she let the hair down. The King's son ascended, but he did not find his dearest Rapunzel above, but the enchantress, who gazed at him with wicked and venomous looks. \"Aha!\" she cried mockingly, \"Thou wouldst fetch thy dearest, but the beautiful bird sits no longer singing in the nest; the cat has got it, and will scratch out thy eyes as well. Rapunzel is lost to thee; thou wilt never see her more.\" The King's son was beside himself with pain, and in his despair he leapt down from the tower. He escaped with his life, but the thorns into which he fell, pierced his eyes. Then he wandered quite blind about the forest, ate nothing but roots and berries, and did nothing but lament and weep over the loss of his dearest wife. Thus he roamed about in misery for some years, and at length came to the desert where Rapunzel, with the twins to which she had given birth, a boy and a girl, lived in wretchedness. He heard a voice, and it seemed so familiar to him that he went towards it, and when he approached, Rapunzel knew him and fell on his neck and wept. Two of her tears wetted his eyes and they grew clear again, and he could see with them as before. He led her to his kingdom where he was joyfully received, and they lived for a long time afterwards, happy and contented.";

        String rapunzel1 = rapunzel.replace("'", "''");
       // String rapunzel2 = rapunzel1.replace("!", "!!");
       // String rapunzel3 = rapunzel2.replace(";", ".");
        String raounzelGood="INSERT INTO MisCONTENIDOCUENTOS VALUES(41,41,'This tale teaches many lessons to children. The consequences of stealing, the value of patience and determination, are some of these qualities. It is because of Rapunzel’s parents actions that Rapunzel is taken away by the witch. Yet at the end of the story, it is the young lovers patience and determination to find each other that unite them.\n" +
                "\n" +
                "Therefore, the moral of the story can be described as follows. When something is destined to happen then no one, by any of their powers, can stop that from happening. We should never give up on our hopes no matter how bad or hard the situation.\n" +
                "\n" +
                "However, this tale could also have a different interpretation for adults. It serves as a caution for adults that children grow up no matter how hard the parents try to shield them from the harsh realities of life.','"+rapunzel1+"')";

        String velvet="There was once a velveteen rabbit, and in the beginning he was really splendid. He was fat and bunchy, as a rabbit should be; his coat was spotted brown and white, he had real thread whiskers, and his ears were lined with pink sateen. On Christmas morning, when he sat wedged in the top of the Boy’s stocking, with a sprig of holly between his paws, the effect was charming.\n" +
                "\n" +
                "There were other things in the stocking, nuts and oranges and a toy engine, and chocolate almonds and a clockwork mouse, but the Rabbit was quite the best of all. For at least two hours the Boy loved him, and then Aunts and Uncles came to dinner, and there was a great rustling of tissue paper and unwrapping of parcels, and in the excitement of looking at all the new presents the Velveteen Rabbit was forgotten.\n" +
                "\n" +
                "For a long time he lived in the toy cupboard or on the nursery floor, and no one thought very much about him. He was naturally shy, and being only made of velveteen, some of the more expensive toys quite snubbed him. The mechanical toys were very superior, and looked down upon every one else; they were full of modern ideas, and pretended they were real. The model boat, who had lived through two seasons and lost most of his paint, caught the tone from them and never missed an opportunity of referring to his rigging in technical terms. The Rabbit could not claim to be a model of anything, for he didn’t know that real rabbits existed; he thought they were all stuffed with sawdust like himself, and he understood that sawdust was quite out-of-date and should never be mentioned in modern circles. Even Timothy, the jointed wooden lion, who was made by the disabled soldiers, and should have had broader views, put on airs and pretended he was connected with Government. Between them all the poor little Rabbit was made to feel himself very insignificant and commonplace, and the only person who was kind to him at all was the Skin Horse.\n" +
                "\n" +
                "\n" +
                "The Velveteen Rabbit and other Christmas toysThe Skin Horse had lived longer in the nursery than any of the others. He was so old that his brown coat was bald in patches and showed the seams underneath, and most of the hairs in his tail had been pulled out to string bead necklaces. He was wise, for he had seen a long succession of mechanical toys arrive to boast and swagger, and by-and-by break their mainsprings and pass away, and he knew that they were only toys, and would never turn into anything else. For nursery magic is very strange and wonderful, and only those playthings that are old and wise and experienced like the Skin Horse understand all about it.\n" +
                "\n" +
                "\"What is REAL?\" asked the Rabbit one day, when they were lying side by side near the nursery fender, before Nana came to tidy the room. \"Does it mean having things that buzz inside you and a stick-out handle?\"\n" +
                "\n" +
                "\"Real isn't how you are made,\" said the Skin Horse. \"It's a thing that happens to you. When a child loves you for a long, long time, not just to play with, but REALLY loves you, then you become Real.\"\n" +
                "\n" +
                "\"Does it hurt?\" asked the Rabbit.\n" +
                "\n" +
                "\"Sometimes,\" said the Skin Horse, for he was always truthful. \"When you are Real you don't mind being hurt.\"\n" +
                "\n" +
                "\"Does it happen all at once, like being wound up,\" he asked, \"or bit by bit?\"\n" +
                "\n" +
                "\"It doesn't happen all at once,\" said the Skin Horse. \"You become. It takes a long time. That's why it doesn't often happen to people who break easily, or have sharp edges, or who have to be carefully kept. Generally, by the time you are Real, most of your hair has been loved off and your eyes drop out and you get loose in the joints and very shabby. But these things don't matter at all, because once you are Real you can't be ugly, except to people who don't understand.\"\n" +
                "\n" +
                "\"I suppose you are Real?\" said the Rabbit. And then he wished he had not said it, for he thought the Skin Horse might be sensitive. But the Skin Horse only smiled.\n" +
                "\n" +
                "\"The Boy's Uncle made me Real,\" he said. \"That was a great many years ago; but once you are Real you can't become unreal again. It lasts for always.\"\n" +
                "\n" +
                "The Rabbit sighed. He thought it would be a long time before this magic called Real happened to him. He longed to become Real, to know what it felt like; and yet the idea of growing shabby and losing his eyes and whiskers was rather sad. He wished that he could become it without these uncomfortable things happening to him.\n" +
                "\n" +
                "There was a person called Nana who ruled the nursery. Sometimes she took no notice of the playthings lying about, and sometimes, for no reason whatever, she went swooping about like a great wind and hustled them away in cupboards. She called this \"tidying up,\" and the playthings all hated it, especially the tin ones. The Rabbit didn't mind it so much, for wherever he was thrown he came down soft.\n" +
                "\n" +
                "One evening, when the Boy was going to bed, he couldn't find the china dog that always slept with him. Nana was in a hurry, and it was too much trouble to hunt for china dogs at bedtime, so she simply looked about her, and seeing that the toy cupboard door stood open, she made a swoop.\n" +
                "\n" +
                "\"Here,\" she said, \"take your old Bunny! He'll do to sleep with you!\" And she dragged the Rabbit out by one ear, and put him into the Boy's arms.\n" +
                "\n" +
                "That night, and for many nights after, the Velveteen Rabbit slept in the Boy’s bed. At first he found it rather uncomfortable, for the Boy hugged him very tight, and sometimes he rolled over on him, and sometimes he pushed him so far under the pillow that the Rabbit could scarcely breathe. And he missed, too, those long moonlight hours in the nursery, when all the house was silent, and his talks with the Skin Horse. But very soon he grew to like it, for the Boy used to talk to him, and made nice tunnels for him under the bedclothes that he said were like the burrows the real rabbits lived in. And they had splendid games together, in whispers, when Nana had gone away to her supper and left the nightlight burning on the mantelpiece. And when the Boy dropped off to sleep, the Rabbit would snuggle down close under his little warm chin and dream, with the Boy's hands clasped close round him all night long.\n" +
                "\n" +
                "And so time went on, and the little Rabbit was very happy—so happy that he never noticed how his beautiful velveteen fur was getting shabbier and shabbier, and his tail coming unsewn, and all the pink rubbed off his nose where the Boy had kissed him.\n" +
                "\n" +
                "Spring came, and they had long days in the The Velveteen Rabbit is happy and lovedgarden, for wherever the Boy went the Rabbit went too. He had rides in the wheelbarrow, and picnics on the grass, and lovely fairy huts built for him under the raspberry canes behind the flower border. And once, when the Boy was called away suddenly to go out to tea, the Rabbit was left out on the lawn until long after dusk, and Nana had to come and look for him with the candle because the Boy couldn’t go to sleep unless he was there. He was wet through with the dew and quite earthy from diving into the burrows the Boy had made for him in the flower bed, and Nana grumbled as she rubbed him off with a corner of her apron.\n" +
                "\n" +
                "\"You must have your old Bunny!\" she said. \"Fancy all that fuss for a toy!\"\n" +
                "\n" +
                "The Boy sat up in bed and stretched out his hands.\n" +
                "\n" +
                "\"Give me my Bunny!\" he said. \"You mustn't say that. He isn’t a toy. He’s REAL!\"\n" +
                "\n" +
                "When the little Rabbit heard that he was happy, for he knew that what the Skin Horse had said was true at last. The nursery magic had happened to him, and he was a toy no longer. He was Real. The Boy himself had said it.\n" +
                "\n" +
                "That night he was almost too happy to sleep, and so much love stirred in his little sawdust heart that it almost burst. And into his boot-button eyes, that had long ago lost their polish, there came a look of wisdom and beauty, so that even Nana noticed it next morning when she picked him up, and said, \"I declare if that old Bunny hasn't got quite a knowing expression!\"\n" +
                "\n" +
                "\n" +
                "That was a wonderful Summer!\n" +
                "\n" +
                "Near the house where they lived there was a wood, and in the long June evenings the Boy liked to go there after tea to play. He took the Velveteen Rabbit with him, and before he wandered off to pick flowers, or play at brigands among the trees, he always made the Rabbit a little nest somewhere among the bracken, where he would be quite cosy, for he was a kind-hearted little boy and he liked Bunny to be comfortable. One evening, while the Rabbit was lying there alone, watching the ants that ran to and fro between his velvet paws in the grass, he saw two strange beings creep out of the tall bracken near him.\n" +
                "\n" +
                "They were rabbits like himself, but quite furry and brand-new. They must have been very well The Velveteen Rabbit plays outsidemade, for their seams didn't show at all, and they changed shape in a queer way when they moved; one minute they were long and thin and the next minute fat and bunchy, instead of always staying the same like he did. Their feet padded softly on the ground, and they crept quite close to him, twitching their noses, while the Rabbit stared hard to see which side the clockwork stuck out, for he knew that people who jump generally have something to wind them up. But he couldn't see it. They were evidently a new kind of rabbit altogether.\n" +
                "\n" +
                "They stared at him, and the little Rabbit stared back. And all the time their noses twitched.\n" +
                "\n" +
                "\"Why don't you get up and play with us?\" one of them asked.\n" +
                "\n" +
                "\"I don't feel like it,\" said the Rabbit, for he didn't want to explain that he had no clockwork.\n" +
                "\n" +
                "\"Ho!\" said the furry rabbit. \"It's as easy as anything.\" And he gave a big hop sideways and stood on his hind legs.\n" +
                "\n" +
                "\"I don't believe you can!\" he said.\n" +
                "\n" +
                "\"I can!\" said the little Rabbit. \"I can jump higher than anything!\" He meant when the Boy threw him, but of course he didn't want to say so.\n" +
                "\n" +
                "\"Can you hop on your hind legs?\" asked the furry rabbit.\n" +
                "\n" +
                "That was a dreadful question, for the Velveteen Rabbit had no hind legs at all! The back of him was made all in one piece, like a pincushion. He sat still in the bracken, and hoped that the other rabbits wouldn't notice.\n" +
                "\n" +
                "\"I don't want to!\" he said again.\n" +
                "\n" +
                "But the wild rabbits have very sharp eyes. And this one stretched out his neck and looked.\n" +
                "\n" +
                "\"He hasn't got any hind legs!\" he called out. \"Fancy a rabbit without any hind legs!\" And he began to laugh.\n" +
                "\n" +
                "\"I have!\" cried the little Rabbit. \"I have got hind legs! I am sitting on them!\"\n" +
                "\n" +
                "\"Then stretch them out and show me, like this!\" said the wild rabbit. And he began to whirl round and dance, till the little Rabbit got quite dizzy.\n" +
                "\n" +
                "\"I don't like dancing,\" he said. \"I'd rather sit still!\"\n" +
                "\n" +
                "But all the while he was longing to dance, for a funny new tickly feeling ran through him, and he felt he would give anything in the world to be able to jump about like these rabbits did.\n" +
                "\n" +
                "The strange rabbit stopped dancing, and came quite close. He came so close this time that his long whiskers brushed the Velveteen Rabbit's ear, and then he wrinkled his nose suddenly and flattened his ears and jumped backwards.\n" +
                "\n" +
                "\"He doesn’t smell right!\" he exclaimed. \"He isn’t a rabbit at all! He isn’t real!\"\n" +
                "\n" +
                "\"I am Real!\" said the little Rabbit, \"I am Real! The Boy said so!\" And he nearly began to cry.\n" +
                "\n" +
                "Just then there was a sound of footsteps, and the Boy ran past near them, and with a stamp of feet and a flash of white tails the two strange rabbits disappeared.\n" +
                "\n" +
                "\"Come back and play with me!\" called the little Rabbit. \"Oh, do came back! I know I am Real!\"\n" +
                "\n" +
                "But there was no answer, only the little ants ran to and fro, and the bracken swayed gently where the two strangers had passed. The Velveteen Rabbit was all alone.\n" +
                "\n" +
                "\"Oh, dear!\" he thought. \"Why did they run away like that? Why couldn't they stop and talk to me?\" For a long time he lay very still, watching the bracken, and hoping that they would come back. But they never returned, and presently the sun sank lower and the little white moths fluttered out, and the Boy came and carried him home.\n" +
                "\n" +
                "\n" +
                "Weeks passed, and the little Rabbit grew very old and shabby, but the Boy loved him just as much. He loved him so hard that he loved all his whiskers off, and the pink lining to his ears turned grey, and his brown spots faded. He even began to lose his shape, and he scarcely looked like a rabbit any more, except to the Boy. To him he was always beautiful, and that was all that the little Rabbit cared about. He didn’t mind how he looked to other people, because the nursery magic had made him Real, and when you are Real shabbiness doesn't matter.\n" +
                "\n" +
                "And then, one day, the Boy was ill.\n" +
                "\n" +
                "His face grew very flushed, and he talked in his sleep, and his little body was so hot that it burned the Rabbit when he held him close. Strange people came and went in the nursery, and a light burned all night, and through it all the little Velveteen Rabbit lay there, hidden from sight under the bedclothes, and he never stirred, for he The Velveteen Rabbit loves the boy and waits patiently for himwas afraid that if they found him some one might take him away, and he knew that the Boy needed him.\n" +
                "\n" +
                "It was a long weary time, for the Boy was too ill to play, and the little Rabbit found it rather dull with nothing to do all day long. But he snuggled down patiently, and looked forward to the time when the Boy should be well again, and they would go out in the garden amongst the flowers and the butterflies and play splendid games in the raspberry thicket like they used to. All sorts of delightful things he planned, and while the Boy lay half asleep he crept up close to the pillow and whispered them in his ear. And presently the fever turned, and the Boy got better. He was able to sit up in bed and look at picture books, while the little Rabbit cuddled close at his side. And one day, they let him get up and dress.\n" +
                "\n" +
                "It was a bright, sunny morning, and the windows stood wide open. They had carried the Boy out on to the balcony, wrapped in a shawl, and the little Rabbit lay tangled up among the bedclothes, thinking.\n" +
                "\n" +
                "The Boy was going to the seaside to-morrow. Everything was arranged, and now it only remained to carry out the doctor's orders. They talked about it all, while the little Rabbit lay under the bedclothes, with just his head peeping out, and listened. The room was to be disinfected, and all the books and toys that the Boy had played with in bed must be burnt.\n" +
                "\n" +
                "\"Hurrah!\" thought the little Rabbit. \"To-morrow we shall go to the seaside!\" For the Boy had often talked of the seaside, and he wanted very much to see the big waves coming in, and the tiny crabs, and the sand castles.\n" +
                "\n" +
                "Just then Nana caught sight of him.\n" +
                "\n" +
                "\"How about his old Bunny?\" she asked.\n" +
                "\n" +
                "\"That?\" said the doctor. \"Why, it’s a mass of scarlet fever germs!—Burn it at once. What? Nonsense! Get him a new one. He mustn’t have that any more!\"\n" +
                "\n" +
                "And so the little Rabbit was put into a sack with the old picture-books and a lot of rubbish, and carried out to the end of the garden behind the fowl-house. That was a fine place to make a bonfire, only the gardener was too busy just then to attend to it. He had the potatoes to dig and the green peas to gather, but next morning he promised to come quite early and burn the whole lot.\n" +
                "\n" +
                "That night the Boy slept in a different bedroom, and he had a new bunny to sleep with him. It was a splendid bunny, all white plush with real glass eyes, but the Boy was too excited to care very much about it. For to-morrow he was going to the seaside, and that in itself was such a wonderful thing that he could think of nothing else.\n" +
                "\n" +
                "And while the Boy was asleep, dreaming of the seaside, the little Rabbit lay among the old picture-books in the corner behind the fowlhouse, and he felt very lonely. The sack had been left untied, and so by wriggling a bit he was able to get his head through the opening and look out. He was shivering a little, for he had always been used to sleeping in a proper bed, and by this time his coat had worn so thin and threadbare from hugging that it was no longer any protection to him. Near by he could see the thicket of raspberry canes, growing tall and close like a tropical jungle, in whose shadow he had played with the Boy on bygone mornings. He thought of those long sunlit hours in the garden—how happy they were—and a great sadness came over him. He seemed to see them all pass before him, each more beautiful than the other, the fairy huts in the flower-bed, the quiet evenings in the wood when he lay in the bracken and the little ants ran over his paws; the wonderful day when he first knew that he was Real. He thought of the Skin Horse, so wise and gentle, and all that he had told him. Of what use was it to be loved and lose one’s beauty and become Real if it all ended like this? And a tear, a real tear, trickled down his little shabby velvet nose and fell to the ground.\n" +
                "\n" +
                "And then a strange thing happened. For where the tear had fallen a flower grew out of the ground, a mysterious flower, not at all like any that grew in the garden. It had slender green leaves the colour of emeralds, and in the centre of the leaves a blossom like a golden cup. It was so beautiful that the little Rabbit forgot to cry, and just lay there watching it. And presently the blossom opened, and out of it there stepped a fairy.\n" +
                "\n" +
                "She was quite the loveliest fairy in the whole world. Her dress was of pearl and dewdrops, and there were flowers round her neck and in her hair, and her face was like the most perfect flower of all. And she came close to the little Rabbit and gathered him up in her arms and kissed him The lovely fairy brings magic to the story.on his velveteen nose that was all damp from crying.\n" +
                "\n" +
                "\"Little Rabbit,\" she said, \"don't you know who I am?\"\n" +
                "\n" +
                "The Rabbit looked up at her, and it seemed to him that he had seen her face before, but he couldn't think where.\n" +
                "\n" +
                "\"I am the nursery magic Fairy,\" she said. \"I take care of all the playthings that the children have loved. When they are old and worn out and the children don't need them any more, then I come and take them away with me and turn them into Real.\"\n" +
                "\n" +
                "\"Wasn't I Real before?\" asked the little Rabbit.\n" +
                "\n" +
                "\"You were Real to the Boy,\" the Fairy said, \"because he loved you. Now you shall be real to every one.\"\n" +
                "\n" +
                "And she held the little Rabbit close in her arms and flew with him into the wood.\n" +
                "\n" +
                "It was light now, for the moon had risen. All the forest was beautiful, and the fronds of the bracken shone like frosted silver. In the open glade between the tree-trunks the wild rabbits danced with their shadows on the velvet grass, but when they saw the Fairy they all stopped dancing and stood round in a ring to stare at her.\n" +
                "\n" +
                "\"I’ve brought you a new playfellow,\" the Fairy said. \"You must be very kind to him and teach him all he needs to know in Rabbitland, for he is going to live with you for ever and ever!\"\n" +
                "\n" +
                "And she kissed the little Rabbit again and put him down on the grass.\n" +
                "\n" +
                "\"Run and play, little Rabbit!\" she said.\n" +
                "\n" +
                "But the little Rabbit sat quite still for a moment and never moved. For when he saw all the wild rabbits dancing around him he suddenly remembered about his hind legs, and he didn’t want them to see that he was made all in one piece. He did not know that when the Fairy kissed him that last time she had changed him altogether. And he might have sat there a long time, too shy to move, if just then something hadn't tickled his nose, and before he thought what he was doing he lifted his hind toe to scratch it.\n" +
                "\n" +
                "And he found that he actually had hind legs! Instead of dingy velveteen he had brown fur, soft and shiny, his ears twitched by themselves, and his whiskers were so long that they brushed the grass. He gave one leap and the joy of using those hind legs was so great that he went springing about the turf on them, jumping sideways and whirling round as the others did, and he grew so excited that when at last he did stop to look for the Fairy she had gone.\n" +
                "\n" +
                "He was a Real Rabbit at last, at home with the other rabbits.\n" +
                "\n" +
                "\n" +
                "Autumn passed and Winter, and in the Spring, when the days grew warm and sunny, the Boy went out to play in the wood behind the house. And while he was playing, two rabbits crept out from the bracken and peeped at him. One of them was brown all over, but the other had strange markings under his fur, as though long ago he had been spotted, and the spots still showed through. And about his little soft nose and his round black eyes there was something familiar, so that the Boy thought to himself:\n" +
                "\n" +
                "\"Why, he looks just like my old Bunny that was lost when I had scarlet fever!\"\n" +
                "\n" +
                "But he never knew that it really was his own Bunny, come back to look at the child who had first helped him to be Real.";
        String velvet1 = velvet.replace("'", "''");
        //String velvet2 = velvet1.replace("!", "!!");
        //String velvet3 = velvet2.replace(";", ".");
        String velvetGood="INSERT INTO MisCONTENIDOCUENTOS VALUES(42,42,'The Velveteen Rabbit starts out on Christmas morning. A young boy finds a stuffed rabbit nestled in his stocking. He loves the rabbit but forgets about him when more glamorous and expensive Christmas presents arrive. But chance will intervene twice in this magical story about childhood toys and the transformative power of love.','"+velvet1+"')";
       // System.out.println(pruebaContenidoIngles);

        String shoe="Once on a time there was a Little Old Woman who lived in a Shoe. This shoe stood near a great forest, and was so large that it served as a house for the Old Lady and all her children, of which she had so many that she did not know what to do with them.\n" +
                "\n" +
                "But the Little Old Woman was very fond of her children, and they only thought of the best way to please her. Strong-arm, the eldest, cut down trees for firewood. Peter made baskets of wicker-work. Mark was chief gardener. Lizzie milked the cow, and Jenny taught the younger children to read.\n" +
                "\n" +
                "Now this Little Old Woman had not always lived in a Shoe. She and her family had once dwelt in a nice house covered with ivy, and her husband was a wood-cutter, like Strong-arm. But there lived in a huge castle beyond the forest, a fierce giant, who one day came and laid their house in ruins with his club; after which he carried off the poor wood-cutter to his castle beyond the forest. When the Little Old Woman came home, her house was in ruins and her husband was no where to be seen.\n" +
                "\n" +
                "The Little Old Woman Who Lived in a Shoe Giant\n" +
                "\n" +
                "Night came on, and as the father did not return, the Old Lady and her family went to search for him. When they came to that part of the wood where the Giant had met their father, they saw an immense shoe. They spent a long time weeping and calling out for their father, but met with no reply. Then the Old Lady thought that they had better take shelter in the shoe until they could build a new house. So Peter and Strong-arm put a roof to it, and cut a door, and turned it into a dwelling. Here they all lived happily for many years, but the Little Old Lady never forgot her husband and his sad fate. Strong-arm, who saw how wretched his mother often was about it, proposed to the next eleven brothers that they should go with him and set their father free from the Giant. Their mother knew the Giant's strength, and would not hear of the attempt, as she feared they would be killed. But Strong-arm was not afraid. He bought a dozen sharp swords, and Peter made as many strong shields and helmets, as well as cross-bows and iron-headed arrows. They were now quite ready; Strong-arm gave the order to march, and they started for the forest. The next day they came in sight of the Giant's Castle. Strong-arm, leaving his brothers in a wood close by, strode boldly up to the entrance, and seized the knocker. The door was opened by a funny little boy with a large head, who kept grinning and laughing.\n" +
                "\n" +
                "The Little Old Woman Who Lived in a Shoe Strong-arm\n" +
                "\n" +
                "Strong-arm then walked boldly across the court-yard, and presently met a page, who took off his hat and asked him what he wanted. Strong-arm said he had come to liberate his father, who was kept a prisoner by the Giant; on this the little man said he was sorry for him, because the part of the castle in which his father was kept was guarded by a large dragon. Strong-arm, nothing daunted, soon found the monster, who was fast asleep, so he made short work of him by sending his sword right through his heart; at which he jumped up, uttering a loud scream, and made as if he would spring forward and seize Strong-arm; but the good sword had done its work, and the monster fell heavily on the ground, dead.\n" +
                "\n" +
                "The Little Old Woman Who Lived in a Shoe Dragon\n" +
                "\n" +
                "Now the Giant, who had been drinking much wine, was fast asleep in a remote part of the castle. Strong-arm had no sooner finished the Dragon, than up started the funny little boy who had opened the door. He led Strong-arm round to another part of the court-yard, where he saw his poor father, who at once sprung to his feet, and embraced him. Then Strong-arm called up his brothers, and when they had embraced their father, they soon broke his chain and set him free.\n" +
                "\n" +
                "We must now return to the Little Old Woman. After her sons had started she gave way to the most bitter grief. While she was in this state, an old witch came up to her, and said she would help her, as she hated the Giant, and wished to kill him. The Old Witch then took the little Old Lady on her broom, and they sailed off through the air, straight to the Giant's castle.\n" +
                "\n" +
                "The Little Old Woman Who Lived in a Shoe Witch\n" +
                "\n" +
                "Now this old Witch had great power, and at once afflicted the Giant with corns and tender feet. When he awoke from his sleep he was in such pain that he could bear it no longer, so he thought he would go in search of his missing shoe, which, like the other one he had in his castle, was easy and large for his foot. When he came to the spot where the Old Lady and her children lived, he saw his old shoe, and with a laugh that shook the trees, he thrust his foot into it, breaking through the roof that Strong-arm and Peter had put to it. The children, in great alarm, rushed about inside the shoe, and frightened and trembling, scrambled through the door and the slits which the Giant had formerly made for his corns. By this time the witch and the Little Old Lady, as also Strong-arm, his eleven brother and his father, were come up to the spot. Strong-arm and his brothers shot their arrows at him till at last he fell wounded, when Strong-arm went up to him and cut off his head. Then the father and the Little Old Woman and all their children built a new house, and lived happily ever afterwards.";
        String shoe1 = shoe.replace("'", "''");
       // String  shoe2 = shoe1.replace("!", "!!");
       // String shoe3 = shoe2.replace(";", ".");
        String shoeGood="INSERT INTO MisCONTENIDOCUENTOS VALUES(43,43,'The Little Old Woman Who Lived in a Shoe is one of our Favorite Fairy Tales, published in My First Picture Book, Printed in colours by Kronheim (1875). You might also enjoy reading Mother Goose''s nursery rhyme, There was an Old Woman Who Lived in a Shoe, and L. Frank Baum''s short story, The Woman Who Lived in a Shoe.','"+shoe1+"')";

        String twas="Twas the night before Christmas, when all through the house\n" +
                "Not a creature was stirring, not even a mouse.\n" +
                "The stockings were hung by the chimney with care,\n" +
                "In hopes that St Nicholas soon would be there.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "The children were nestled all snug in their beds,\n" +
                "While visions of sugar-plums danced in their heads.\n" +
                "And mamma in her ‘kerchief, and I in my cap,\n" +
                "Had just settled our brains for a long winter’s nap.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "When out on the lawn there arose such a clatter,\n" +
                "I sprang from the bed to see what was the matter.\n" +
                "Away to the window I flew like a flash,\n" +
                "Tore open the shutters and threw up the sash.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "The moon on the breast of the new-fallen snow\n" +
                "Gave the lustre of mid-day to objects below.\n" +
                "When, what to my wondering eyes should appear,\n" +
                "But a miniature sleigh, and eight tiny reindeer.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "With a little old driver, so lively and quick,\n" +
                "I knew in a moment it must be St Nick.\n" +
                "More rapid than eagles his coursers they came,\n" +
                "And he whistled, and shouted, and called them by name!\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "\"Now Dasher! now, Dancer! now, Prancer and Vixen!\n" +
                "On, Comet! On, Cupid! on, on Donner and Blitzen!\n" +
                "To the top of the porch! to the top of the wall!\n" +
                "Now dash away! Dash away! Dash away all!\"\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "As dry leaves that before the wild hurricane fly,\n" +
                "When they meet with an obstacle, mount to the sky.\n" +
                "So up to the house-top the coursers they flew,\n" +
                "With the sleigh full of Toys, and St Nicholas too.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "And then, in a twinkling, I heard on the roof\n" +
                "The prancing and pawing of each little hoof.\n" +
                "As I drew in my head, and was turning around,\n" +
                "Down the chimney St Nicholas came with a bound.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "He was dressed all in fur, from his head to his foot,\n" +
                "And his clothes were all tarnished with ashes and soot.\n" +
                "A bundle of Toys he had flung on his back,\n" +
                "And he looked like a peddler, just opening his pack.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "His eyes-how they twinkled! his dimples how merry!\n" +
                "His cheeks were like roses, his nose like a cherry!\n" +
                "His droll little mouth was drawn up like a bow,\n" +
                "And the beard of his chin was as white as the snow.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "The stump of a pipe he held tight in his teeth,\n" +
                "And the smoke it encircled his head like a wreath.\n" +
                "He had a broad face and a little round belly,\n" +
                "That shook when he laughed, like a bowlful of jelly!\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "He was chubby and plump, a right jolly old elf,\n" +
                "And I laughed when I saw him, in spite of myself!\n" +
                "A wink of his eye and a twist of his head,\n" +
                "Soon gave me to know I had nothing to dread.\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "He spoke not a word, but went straight to his work,\n" +
                "And filled all the stockings, then turned with a jerk.\n" +
                "And laying his finger aside of his nose,\n" +
                "And giving a nod, up the chimney he rose!\n" +
                "\n" +
                "illustration for Twas The Night Before Christmas\n" +
                "He sprang to his sleigh, to his team gave a whistle,\n" +
                "And away they all flew like the down of a thistle.\n" +
                "But I heard him exclaim, ‘ere he drove out of sight,\n" +
                "\"Happy Christmas to all, and to all a good-night!\"";

        String twas1 = twas.replace("'", "''");
        String twas2 = twas1.replace("!", "!!");
        String twas3 = twas2.replace(";", ".");
        String twasGood="INSERT INTO MisCONTENIDOCUENTOS VALUES(44,44,'Twas the Night Before Christmas was first published in 1823 as \"Account of a Visit from St. Nicholas\" in the Troy Sentinel, later attributed to Clement C. Moore and renamed. ','"+twas3+"')";

        String santa="My Dear Susy Clemens,\n" +
                "\n" +
                "I have received and read all the letters which you and your little sister have written me . . . . I can read your and your baby sister's jagged and fantastic marks without any trouble at all. But I had trouble with those letters which you dictated through your mother and the nurses, for I am a foreigner and cannot read English writing well. You will find that I made no mistakes about the things which you and the baby ordered in your own letters--I went down your chimney at midnight when you were asleep and delivered them all myself--and kissed both of you, too . . . . But . . . there were . . . one or two small orders which I could not fill because we ran out of stock . . . .\n" +
                "\n" +
                "There was a word or two in your mama's letter which . . . I took to be \"a trunk full of doll's clothes.\" Is that it? I will call at your kitchen door about nine o'clock this morning to inquire. But I must not see anybody and I must not speak to anybody but you. When the kitchen doorbell rings, George must be blindfolded and sent to the door. You must tell George he must walk on tiptoe and not speak-- otherwise he will die someday. Then you must go up to the nursery and stand on a chair or the nurse's bed and put your ear to the speaking tube that leads down to the kitchen and when I whistle through it you must speak in the tube and say, \"Welcome, Santa Claus!\" Then I will ask whether it was a trunk you ordered or not. If you say it was, I shall ask you what color you want the trunk to be . . . and then you must tell me every single thing in detail which you want the trunk to contain. Then when I say \"Good-by and a merry Christmas to my little Susy Clemens,\" you must say \"Good-by, good old Santa Claus, I thank you very much.\" Then you must go down into the library and make George close all the doors that open into the main hall, and everybody must keep still for a little while. I will go to the moon and get those things and in a few minutes I will come down the chimney that belongs to the fireplace that is in the hall--if it is a trunk you want--because I couldn't get such a thing as a trunk down the nursery chimney, you know . . . .If I should leave any snow in the hall, you must tell George to sweep it into the fireplace, for I haven't time to do such things. George must not use a broom, but a rag--else he will die someday . . . . If my boot should leave a stain on the marble, George must not holystone it away. Leave it there always in memory of my visit; and whenever you look at it or show it to anybody you must let it remind you to be a good little girl. Whenever you are naughty and someone points to that mark which your good old Santa Claus's boot made on the marble, what will you say, little sweetheart?";

        String santa1 = santa.replace("'", "''");
       // String santa2 = santa1.replace("!", "!!");
       // String santa3 = santa2.replace(";", ".");
        String santaGood="INSERT INTO MisCONTENIDOCUENTOS VALUES(45,45,'Mark Twain wrote this letter to his 3 year old daughter from Santa Claus in 1875. You could say he was over the moon for her.','"+santa1+"')";


        Cursor cursor = db.rawQuery("SELECT * FROM CUENTOS", null);
        while (cursor.moveToNext()) {
            if (cursor.getCount() > 0) {
                db.execSQL("DELETE FROM CUENTOS");
                db.execSQL("DELETE FROM TIPOCUENTO");
                db.execSQL("DELETE FROM MisCONTENIDOCUENTOS");
            }
        }
        //Mejor haz un método por que lo utilizaras varias veces amigo!!!!
        insertData(db, sql);
        insertData(db, sqlBueno);
        db.execSQL(cuento5);
        db.execSQL(cuento6);
        db.execSQL(cuentoMagoOz);
        db.execSQL(pruebaIngles);
        db.execSQL(pruebaIngles2Bremen);
        db.execSQL(threeLittlePigs);
        db.execSQL(duck4);
        db.execSQL(princessPee);
        db.execSQL(bellaDurmiente);
        db.execSQL(mermaidGood);
        db.execSQL(raounzelGood);
        db.execSQL(velvetGood);
        db.execSQL(shoeGood);
        db.execSQL(twasGood);

        db.execSQL(santaGood);

        insertData(db, Cuentos11_16);
        insertData(db, cuento17_20);

        db.close();
    }

    private void insertData(SQLiteDatabase db,String sql) {

        String [] qsl = sql.split(";");
        for (int i=0;i<qsl.length;i++) {
            db.execSQL(qsl[i]);
        }
    }

    public void consultFromSQLiteContenidoCuentos(ConexionSQLite sq,int id) {

        SQLiteDatabase db = sq.getReadableDatabase();
        String query = "SELECT C.TITULO,C.IMAGE,C.ID,M.CONTENIDO,M.MORALEJA FROM CUENTOS C JOIN MisCONTENIDOCUENTOS M ON C.ID = M.CuentoCID where C.ID = "+id+";";
        Cursor cursor = db.rawQuery(query, null);
        pruebaContenido.removeAll(pruebaContenido);
        while (cursor.moveToNext()) {

            System.out.println(cursor.getCount());
            //  int id = cursor.getInt(0);
            //CuentosRV cRV = new CuentosRV();
            //CuentosRV cRV = new CuentosRV(imgCuentos[cursor.getInt(1)],cursor.getString(0));
            int idImage = cursor.getInt(1);
            String title = cursor.getString(0);
            int Id = cursor.getInt(2);
            String contenido = cursor.getString(3);
            String moraleja = cursor.getString(4);
            CuentosContenido cuentosC = new CuentosContenido();

            cuentosC.setTitle(title);
            cuentosC.setIdimage(idImage);
            cuentosC.setId(Id);
            cuentosC.setContenido(contenido);
            cuentosC.setMoraleja(moraleja);
            System.out.println("werweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee EOOOOOOOO");
            pruebaContenido.add(cuentosC);
            //System.out.println("A ver como salen los cuentos ...." + "---------------" + idImage + "---------------------" + title);
            //System.out.println(contenido);
            //System.out.println(moraleja);
            //System.out.println("***********************");
        }
        //Log.i("CONTACTos", "Array de la base de datos" + misCumpl.toString());
        System.out.println("€€€€€€€€€€ Prueba de cuantos hay en el array!!"+pruebaContenido.size());
        cursor.close();
        db.close();
    }
}
