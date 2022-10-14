package edu.uoc.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.uoc.cardview.modelos.CuentosRV;

public class MainActivity extends AppCompatActivity {

    private ImageView clasicos,cortos,dormir,princesas,ingles,halloween,animales,navideños,menu,exit;
    public static ArrayList<CuentosRV> cuentosRVArrayList = new ArrayList<>();
    private ConexionSQLite sq;
    private UtilitiesSQL utilitiesSQL;
    public static String tipoCuento="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        clasicos = findViewById(R.id.clasicos);
        cortos = findViewById(R.id.cortos);
        dormir = findViewById(R.id.moon);
        princesas = findViewById(R.id.princess);
        ingles = findViewById(R.id.english);
        halloween = findViewById(R.id.hallowen);
        animales = findViewById(R.id.animal);
        navideños = findViewById(R.id.cristmas);
        menu = findViewById(R.id.toolbar);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             AlertDialog.Builder exit= new AlertDialog.Builder(MainActivity.this);
             exit.setMessage("¿Desea salir de la aplicación?");
             exit.setCancelable(true);
             exit.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                     System.exit(0);
                 }
             });
             exit.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                     dialog.cancel();
                 }
             });
                AlertDialog salir =exit.create();
                salir.setTitle("Salir de la Aplicación");
                salir.show();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
            }
        });

        sq = new ConexionSQLite(getApplicationContext(), "MisCUENTOS", null, 1);
        sq = new ConexionSQLite(getApplicationContext(), "TIPOCUENTO", null, 1);
        sq = new ConexionSQLite(getApplicationContext(), "MisCONTENIDOCUENTOS", null, 1);
        utilitiesSQL = new UtilitiesSQL();
        utilitiesSQL.insertCuentos(sq);
        clasicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Eo funcionan", Toast.LENGTH_SHORT).show();
                String query="SELECT C.TITULO,C.IMAGE,C.ID FROM CUENTOS C JOIN TIPOCUENTO T ON C.ID =T.TIPOID WHERE T.GENERO LIKE 'CLASICOS';";
                utilitiesSQL.consultFromSQLiteListCuentos(sq,"SELECT c.titulo,c.image,c.id from cuentos c");
                Intent intent = new Intent(MainActivity.this,CuentosList.class);
                tipoCuento ="Cuentos Clásicos";
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        cortos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query="SELECT C.TITULO,C.IMAGE,c.id FROM CUENTOS C JOIN TIPOCUENTO T ON C.ID =T.TIPOID WHERE T.GENERO LIKE 'CORTOS';";
                utilitiesSQL.consultFromSQLiteListCuentos(sq,query);
                Intent intent = new Intent(MainActivity.this,CuentosList.class);
                tipoCuento ="Cuentos Cortos";
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        dormir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilitiesSQL.consultFromSQLiteContenidoCuentos(sq, 1);
            }
        });

        princesas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        halloween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        animales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query="SELECT C.TITULO,C.IMAGE,c.id FROM CUENTOS C JOIN TIPOCUENTO T ON C.ID =T.TIPOID WHERE T.GENERO LIKE 'ANIMALES';";
                utilitiesSQL.consultFromSQLiteListCuentos(sq,query);
                Intent intent = new Intent(MainActivity.this,CuentosList.class);
                tipoCuento ="Cuentos de Animales";
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        navideños.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /*
    public void consultFromSQLite(String query) {

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
            cRV.setTitle(title);
            cRV.setImage(idImage);
            cuentosRVArrayList.add(cRV);
            System.out.println("A ver como salen los cuentos ...." + "---------------" + idImage + "---------------------" + title);
        }

        //Log.i("CONTACTos", "Array de la base de datos" + misCumpl.toString());
        cursor.close();
        db.close();
    }

    public void insertCuentos() {


        SQLiteDatabase db = sq.getWritableDatabase();
        String sqlBueno;
        String sql = "INSERT INTO CUENTOS VALUES(1,0,'CUENTO DE SIMBAD EL MARINO');\n" +
                "INSERT INTO CUENTOS VALUES(2,1,'CUENTO LOS MÚSICOS DE BREMEN');\n" +
                "INSERT INTO CUENTOS VALUES(3,2,'CUENTO DE LA LEYENDA GUILLERMO TELL');\n" +
                "INSERT INTO CUENTOS VALUES(4,3,'CUENTO DE EL FLAUTISTA DE HAMELÍN');\n" +
                "INSERT INTO CUENTOS VALUES(5,4,'CUENTO LOS VIAJES DE GULIVER');\n" +
                "INSERT INTO CUENTOS VALUES(6,5,'CUENTO DE RICITOS DE ORO Y LOS TRES CERDITOS');\n" +
                "INSERT INTO CUENTOS VALUES(7,6,'CUENTO DE PULGARCITO');\n" +
                "INSERT INTO CUENTOS VALUES(8,7,'CUENTO DE LOS SIETE CABRITILLOS');\n" +
                "INSERT INTO CUENTOS VALUES(9,8,'CUENTO DE LAS ZAPATILLAS ROJAS');\n" +
                "INSERT INTO CUENTOS VALUES(10,9,'CUENTO DE EL GATO CON BOTAS');\n" +
                "INSERT INTO CUENTOS VALUES(11,10,'CUENTO DE BLANCANIEVES Y LOS SIETE ENANITOS');\n" +
                "INSERT INTO CUENTOS VALUES(12,11,'CUENTO DE BAMBI');\n" +
                "INSERT INTO CUENTOS VALUES(13,12,'CUENTO DE PEDRO Y EL LOBO');\n" +
                "INSERT INTO CUENTOS VALUES(14,13,'CUENTO DE ALADINO Y LA LÁMPARA MARAVILLOSA');\n" +
                "INSERT INTO CUENTOS VALUES(15,14,'CUENTO DE PINOCHO');\n" +
                "INSERT INTO CUENTOS VALUES(16,15,'CUENTO DE LA CENICIENTA');\n" +
                "INSERT INTO CUENTOS VALUES(17,16,'FÁBULA DE LA LIEBRE Y LA TORTUGA');\n" +
                "INSERT INTO CUENTOS VALUES(18,17,'FÁBULA DE LA CIGARRA Y LA HORMIGA');\n" +
                "INSERT INTO CUENTOS VALUES(19,18,'CUENTO DE LA LEYENDA GUILLERMO TELL');\n" +
                "INSERT INTO CUENTOS VALUES(20,19,'CUENTO DE GARBANCITO');\n" +
                "INSERT INTO CUENTOS VALUES(21,20,'CENICIENTO Y LAS ZAPATILLAS MÁGICAS');\n" +
                "INSERT INTO CUENTOS VALUES(22,21,'LA VIDA SECRETA DE LOS OBJETOS');\n" +
                "INSERT INTO CUENTOS VALUES(23,22,'CUENTO DE LA CIUDAD SIN COLORES');\n" +
                "INSERT INTO CUENTOS VALUES(24,23,'CUENTO DE EL NIÑO DAVID Y LA BALLENA');\n" +
                "INSERT INTO CUENTOS VALUES(25,24,'CUENTO DE EL DESVÁN DE LA ABUELA');\n" +
                "INSERT INTO CUENTOS VALUES(26,25,'10 CUENTOS PARA DORMIR FELICES');\n" +
                "INSERT INTO CUENTOS VALUES(27,26,'5 CUENTOS DE PRINCESAS PARA LEER Y DORMIR');\n" +
                "INSERT INTO CUENTOS VALUES(28,27,'PULGARCITA CONOCE EL MUNDO');\n" +
                "INSERT INTO CUENTOS VALUES(29,28,'EL PARAGUAS ROJO DE ESTÍBALIZ');\n" +
                "INSERT INTO CUENTOS VALUES(30,29,'CUENTO DE EL GATO SOÑADOR');\n" +
                "INSERT INTO CUENTOS VALUES(31,30,'CUENTO DE LA FAROLA DORMILONA');\n" +
                "INSERT INTO CUENTOS VALUES(32,31,'CUENTO DE EL RELOJ DORADO');\n" +
                "INSERT INTO CUENTOS VALUES(33,32,'CUENTO DE LOS TRES CERDITOS');\n" +
                "INSERT INTO CUENTOS VALUES(35,33,'CUENTO DE EL PATITO FEO');\n" +
                "INSERT INTO CUENTOS VALUES(36,34,'CUENTO DE EL GUSANO QUE QUERÍA SER MARIPOSA DE SEDA');\n" +
                "INSERT INTO CUENTOS VALUES(37,35,'CUENTO LA RATITA PRESUMIDA');\n" +
                "INSERT INTO CUENTOS VALUES(38,36,'CUENTO DE EL CONEJO GRUÑON');\n" +
                "INSERT INTO CUENTOS VALUES(39,37,'CUENTO DE LA PRINCESA Y EL GUISANTE');\n" +
                "INSERT INTO CUENTOS VALUES(40,38,'CUENTO DE LA BELLA DURMIENTE');\n" +
                "INSERT INTO CUENTOS VALUES(43,40,'CUENTO DE RAPUNZEL');\n" +
                "INSERT INTO CUENTOS VALUES(44,41,'10 CUENTOS DE NAVIDAD PARA NIÑOS');\n" +
                "INSERT INTO CUENTOS VALUES(45,42,'CUENTO DE EL RINCÓN DE NIEVE');\n" +
                "INSERT INTO CUENTOS VALUES(46,43,'CUENTO DE EL RENO MORITZ Y SU EXTRAÑA NARIZ');\n" +
                "INSERT INTO CUENTOS VALUES(47,44,'CUENTO DE DARÍO Y LA NIEVE');\n" +
                "INSERT INTO CUENTOS VALUES(48,45,'CUENTO DE EL ÁRBOL DE NAVIDAD SIN NAVIDAD');\n" +
                "INSERT INTO CUENTOS VALUES(49,46,'10 CUENTOS EN INGLÉS PARA NIÑOS');\n" +
                "INSERT INTO CUENTOS VALUES(50,47,'ELEPHANT AMARANTA FEAR');\n" +
                "INSERT INTO CUENTOS VALUES(51,48,'NOELIA WANTS AN OMELETTE');\n" +
                "INSERT INTO CUENTOS VALUES(52,49,'THE SLEEPY LAMPPOST');\n" +
                "INSERT INTO CUENTOS VALUES(53,50,'THE BUNNY WITHOUT EARS');\n" +
                "INSERT INTO CUENTOS VALUES(54,51,'THE VILLAIN OF THE STORY');\n" +
                "INSERT INTO CUENTOS VALUES(55,52,'LEYENDAS URBANAS CORTAS PARA UNA NOCHE DE MIEDO');\n" +
                "INSERT INTO CUENTOS VALUES(56,53,'EL HUESO CANTOR');\n" +
                "INSERT INTO CUENTOS VALUES(57,54,'CUENTO DE JACK-O-LANTERN Y LAS CALABAZAS DE HALLOWEEN');\n" +
                "INSERT INTO CUENTOS VALUES(58,55,'CUENTO DE JUAN SIN MIEDO');\n" +
                "INSERT INTO CUENTOS VALUES(59,56,'CUENTO DE CIENTIFICO LOCO PARA NIÑOS');\n" +
                "INSERT INTO CUENTOS VALUES(60,57,'CUENTO DE CAPERUCITA ROJA');\n" +
                "INSERT INTO CUENTOS VALUES(61,58,'CUENTO DE PETER PAN');\n" +
                "INSERT INTO CUENTOS VALUES(62,59,'CUENTO DE HANSEL Y GRETEL');\n" +
                "INSERT INTO CUENTOS VALUES(63,60,'CUENTO DE SOPA DE LETRAS');\n" +
                "INSERT INTO CUENTOS VALUES(64,61,'CUENTO DE LA NIÑA QUE NO SABÍA REIR');\n" +
                "INSERT INTO TIPOCUENTO VALUES(1,'CLASICOS',1);\n" +
                "INSERT INTO TIPOCUENTO VALUES(2,'CLASICOS',2);\n" +
                "INSERT INTO TIPOCUENTO VALUES(3,'CLASICOS',3);\n" +
                "INSERT INTO TIPOCUENTO VALUES(4,'CLASICOS',4);\n" +
                "INSERT INTO TIPOCUENTO VALUES(5,'CLASICOS',5);\n" +
                "INSERT INTO TIPOCUENTO VALUES(6,'CLASICOS',6);\n" +
                "INSERT INTO TIPOCUENTO VALUES(7,'CLASICOS',7);\n" +
                "INSERT INTO TIPOCUENTO VALUES(8,'CLASICOS',8);\n" +
                "INSERT INTO TIPOCUENTO VALUES(9,'CLASICOS',9);\n" +
                "INSERT INTO TIPOCUENTO VALUES(10,'CLASICOS',10);\n" +
                "INSERT INTO TIPOCUENTO VALUES(11,'CLASICOS',11);\n" +
                "INSERT INTO TIPOCUENTO VALUES(12,'CLASICOS',12);\n" +
                "INSERT INTO TIPOCUENTO VALUES(13,'CLASICOS',13);\n" +
                "INSERT INTO TIPOCUENTO VALUES(14,'CLASICOS',14);\n" +
                "INSERT INTO TIPOCUENTO VALUES(15,'CLASICOS',15);\n" +
                "INSERT INTO TIPOCUENTO VALUES(16,'CLASICOS',16);\n" +
                "INSERT INTO TIPOCUENTO VALUES(12,'ANIMALES',17);\n" +
                "INSERT INTO TIPOCUENTO VALUES(17,'CORTOS',18);\n" +
                "INSERT INTO TIPOCUENTO VALUES(18,'CORTOS',19);\n" +
                "INSERT INTO TIPOCUENTO VALUES(19,'CORTOS',20);\n" +
                "INSERT INTO TIPOCUENTO VALUES(20,'CORTOS',21);\n" +
                "INSERT INTO TIPOCUENTO VALUES(21,'CORTOS',22);\n" +
                "INSERT INTO TIPOCUENTO VALUES(22,'CORTOS',23);\n" +
                "INSERT INTO TIPOCUENTO VALUES(23,'CORTOS',24);\n" +
                "INSERT INTO TIPOCUENTO VALUES(24,'CORTOS',25);\n" +
                "INSERT INTO TIPOCUENTO VALUES(25,'CORTOS',26);\n" +
                "INSERT INTO TIPOCUENTO VALUES(63,'CORTOS',27);\n" +
                "INSERT INTO TIPOCUENTO VALUES(64,'CORTOS',28);\n" +
                "INSERT INTO TIPOCUENTO VALUES(26,'DORMIR',29);\n" +
                "INSERT INTO TIPOCUENTO VALUES(27,'DORMIR',30);\n" +
                "INSERT INTO TIPOCUENTO VALUES(28,'DORMIR',31);\n" +
                "INSERT INTO TIPOCUENTO VALUES(29,'DORMIR',32);\n" +
                "INSERT INTO TIPOCUENTO VALUES(30,'DORMIR',33);\n" +
                "INSERT INTO TIPOCUENTO VALUES(31,'DORMIR',34);\n" +
                "INSERT INTO TIPOCUENTO VALUES(32,'DORMIR',35);\n" +
                "INSERT INTO TIPOCUENTO VALUES(60,'CLASICOS',36);\n" +
                "INSERT INTO TIPOCUENTO VALUES(61,'CLASICOS',37);\n" +
                "INSERT INTO TIPOCUENTO VALUES(62,'CLASICOS',38);\n" +
                "INSERT INTO TIPOCUENTO VALUES(33,'ANIMALES',39);\n" +
                "INSERT INTO TIPOCUENTO VALUES(34,'ANIMALES',40);\n" +
                "INSERT INTO TIPOCUENTO VALUES(35,'ANIMALES',41);\n" +
                "INSERT INTO TIPOCUENTO VALUES(36,'ANIMALES',42);\n" +
                "INSERT INTO TIPOCUENTO VALUES(37,'ANIMALES',43);\n" +
                "INSERT INTO TIPOCUENTO VALUES(38,'ANIMALES',44);\n" +
                "INSERT INTO TIPOCUENTO VALUES(8,'ANIMALES',49);\n" +
                "INSERT INTO TIPOCUENTO VALUES(2,'ANIMALES',45);\n" +
                "INSERT INTO TIPOCUENTO VALUES(10,'ANIMALES',46);\n" +
                "INSERT INTO TIPOCUENTO VALUES(17,'ANIMALES',47);\n" +
                "INSERT INTO TIPOCUENTO VALUES(18,'ANIMALES',48);\n" +
                "INSERT INTO TIPOCUENTO VALUES(27,'PRINCESAS',50);\n" +
                "INSERT INTO TIPOCUENTO VALUES(11,'PRINCESAS',51);\n" +
                "INSERT INTO TIPOCUENTO VALUES(39,'PRINCESAS',52);\n" +
                "INSERT INTO TIPOCUENTO VALUES(40,'PRINCESAS',53);\n" +
                "INSERT INTO TIPOCUENTO VALUES(41,'PRINCESAS',54);\n" +
                "INSERT INTO TIPOCUENTO VALUES(42,'PRINCESAS',55);\n" +
                "INSERT INTO TIPOCUENTO VALUES(43,'PRINCESAS',56);\n" +
                "INSERT INTO TIPOCUENTO VALUES(44,'NAV',57);\n" +
                "INSERT INTO TIPOCUENTO VALUES(45,'NAV',58);\n" +
                "INSERT INTO TIPOCUENTO VALUES(46,'NAV',59);\n" +
                "INSERT INTO TIPOCUENTO VALUES(47,'NAV',60);\n" +
                "INSERT INTO TIPOCUENTO VALUES(48,'NAV',61);\n" +
                "INSERT INTO TIPOCUENTO VALUES(49,'ING',62);\n" +
                "INSERT INTO TIPOCUENTO VALUES(50,'ING',63);\n" +
                "INSERT INTO TIPOCUENTO VALUES(51,'ING',64);\n" +
                "INSERT INTO TIPOCUENTO VALUES(52,'ING',65);\n" +
                "INSERT INTO TIPOCUENTO VALUES(53,'ING',66);\n" +
                "INSERT INTO TIPOCUENTO VALUES(54,'ING',67);";

        Cursor cursor = db.rawQuery("SELECT * FROM CUENTOS", null);

        while (cursor.moveToNext()) {
            if (cursor.getCount() > 0) {
                db.execSQL("DELETE FROM CUENTOS");
                db.execSQL("DELETE FROM TIPOCUENTO");
            }
        }

        String[] qsl = sql.split("\n");
        for (int i = 0; i < qsl.length; i++) {
            db.execSQL(qsl[i]);
            //System.out.println(qsl[i]);
        }
        db.close();
    }
*/
    }

