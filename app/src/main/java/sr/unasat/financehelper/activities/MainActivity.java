package sr.unasat.financehelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import sr.unasat.financehelper.Entity.User;
import sr.unasat.financehelper.R;
import sr.unasat.financehelper.database.FinancialDAO;

public class MainActivity extends AppCompatActivity {

    private FinancialDAO financialDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        financialDAO = new FinancialDAO(this);
        User user = financialDAO.findOneRecordByUsername("admin");

        TextView credentialsTextView = (TextView) findViewById(R.id.credentials);
        String credentialsText = String.format("Username: %s \nPassword: %s",user.getUserName(), user.getPassword());
        credentialsTextView.setText(credentialsText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"action settings selected", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
