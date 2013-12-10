package org.deneblingvo.geneticist.android.test;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.FileInputStream;
import java.io.InputStream;
import org.deneblingvo.geneticist.Geneticist;
import org.deneblingvo.serialization.xml.Reader;
import edu.android.openfiledialog.OpenFileDialog;
import javax.xml.XMLConstants;
import org.xml.sax.helpers.*;

public class MainActivity extends Activity implements OpenFileDialog.OpenDialogListener, OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button button = (Button)findViewById(R.id.but);
		button.setOnClickListener(this);
		//DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		//button.setText(fac.get);
    }
	
	public void OnSelectedFile(String filename) {
		TextView textView = (TextView)findViewById(R.id.txt);
		textView.setText(filename);
		Geneticist gen = new Geneticist();
		Reader reader = new Reader();
		try {
			InputStream file = new FileInputStream(filename);
			reader.read(file, gen);
			if (gen.operators == null) {
				textView.setText("null");
			} else {
				textView.setText("ok");
			}
		} catch (Exception e) {
			textView.setText(e.getMessage());
		}
	}
	
	public void onClick(View v) {
		OpenFileDialog fileDialog = new OpenFileDialog(this);
		fileDialog.setFilter(".*\\.xml");
		fileDialog.setOpenDialogListener(this);
		fileDialog.show();
	}
}
