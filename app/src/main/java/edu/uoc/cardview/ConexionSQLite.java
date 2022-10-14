package edu.uoc.cardview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//
public class ConexionSQLite extends SQLiteOpenHelper {

    final String CREATE_TABLE_MISCUENTOS = "CREATE TABLE IF NOT EXISTS CUENTOS( ID integer NOT NULL , IMAGE integer NOT NULL," +
            " Titulo VARCHAR2,PRIMARY KEY (ID)); ";
    final String CREATE_TABLE_MISTIPOCUENTOS = "CREATE TABLE  TIPOCUENTO( TipoID integer, Genero VARCHAR2, CuentoID INTEGER PRIMARY KEY NOT NULL,FOREIGN KEY(TipoID)REFERENCES MisCUENTOS(ID));";
    final String CREATE_TABLE_MISCONTENIDOCUENTOS = "CREATE TABLE IF NOT EXISTS MisCONTENIDOCUENTOS (ContenidoID integer NOT NULL,CuentoCID integer,Moraleja VARCHAR2," +
            "Contenido TEXT ,PRIMARY KEY (ContenidoID), FOREIGN KEY (CuentoCID) REFERENCES MisCUENTOS(ID));";

    //                                 contexto aplicacion , nombre dfe la base de datos, cursos , version
    public ConexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Creara las tablas que tengamos de nuestras entidades ....
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_MISCUENTOS);
        db.execSQL(CREATE_TABLE_MISTIPOCUENTOS);
        db.execSQL(CREATE_TABLE_MISCONTENIDOCUENTOS);

    }
    //Verifica si ya existe antes una version antigua y otro parametro para una version nueva
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Si existe que la borre y me vuelva a crear la tabla, base de datos.....
        // db.execSQL("DROP TABLE IF EXISTS CUENTOS");
        // onCreate(db);
    }

}


