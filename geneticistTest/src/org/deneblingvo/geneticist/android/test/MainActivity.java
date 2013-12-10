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
import org.deneblingvo.geneticist.Algorithm;
import org.deneblingvo.geneticist.Operator;
import org.deneblingvo.geneticist.Parameter;
import edu.android.openfiledialog.OpenFileDialog;
import javax.xml.XMLConstants;
import org.xml.sax.helpers.*;
import java.util.*;
import net.sf.saxon.xpath.XPathFactoryImpl;

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
    }
	
	public void OnSelectedFile(String filename) {
		TextView textView = (TextView)findViewById(R.id.txt);
		textView.setText(filename);
		Geneticist gen = new Geneticist();
		Reader reader = new Reader(new XPathFactoryImpl());
		try {
			InputStream file = new FileInputStream(filename);
			reader.read(file, gen);
			if (gen.operators == null) {
				textView.setText("null");
			} else {
				textView.setText("ok");
			}
			Algorithm v1 = this.getVar(1, "integer");
			Algorithm v2 = this.getVar(2, "integer");
			Algorithm a = new Algorithm();
			a.operator = gen.operators.get(0);
			a.operands = new Vector<Algorithm>();
			a.operands.add(v1);
			a.operands.add(v2);
			String str = a.asString();
			textView.setText(str);
		} catch (Exception e) {
			textView.setText("error:" + e.getMessage());
		}
	}
	
	public Algorithm getVar(int number, String type) {
		Operator variable = new Operator();
		variable.name = "v" + number;
		variable.output = type;
		variable.parameters = new Vector<Parameter>();
		variable.format = variable.name;
		Algorithm algorithm = new Algorithm();
		algorithm.operator = variable;
		algorithm.operands = new Vector<Algorithm>();
		return algorithm;
	}
	
	public void onClick(View v) {
		OpenFileDialog fileDialog = new OpenFileDialog(this);
		fileDialog.setFilter(".*\\.xml");
		fileDialog.setOpenDialogListener(this);
		fileDialog.show();
	}
}
