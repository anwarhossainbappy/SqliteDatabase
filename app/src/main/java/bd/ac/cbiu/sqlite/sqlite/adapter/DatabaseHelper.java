package bd.ac.cbiu.sqlite.sqlite.adapter;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static java.sql.Types.VARCHAR;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="student.db";
    private static final String TABLE_NAME ="student_details";
    private static final String ID ="id";
    private static final String NAME ="name";
    private static final String STUDENT_ID ="student_id";
    private static final String BATCH ="batch";
    private static final int VERSION_NUMBER =2;
    private static final String CREATE_TABLE =("CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+BATCH+" INTEGER,"+STUDENT_ID+" VARCHAR(255))");
    private static final String SELECT_ALL ="SELECT * FROM "+TABLE_NAME;
    private Context context;
    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "Database Created", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);

        }catch (Exception e)
        {
            Toast.makeText(context, "Exception "+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public long insertData(String name, String batch,String sid)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(BATCH,batch);
        values.put(STUDENT_ID,sid);
       long rowId= sqLiteDatabase.insert(TABLE_NAME,null,values);
       return rowId;
    }
    public Cursor displayData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }
    public boolean UpdateData(String id, String name, String sid,String Batch)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(NAME,name);
        contentValues.put(STUDENT_ID,sid);
        contentValues.put(BATCH,Batch);

        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+" = ?",new String[]{id});
        return true;
    }
    public Integer deleteData(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,ID+" = ?",new String[]{ id });
    }
}
