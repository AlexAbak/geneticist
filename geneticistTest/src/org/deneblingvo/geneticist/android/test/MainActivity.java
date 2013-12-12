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
import org.deneblingvo.geneticist.Type;
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
			Operator v1 = Algorithm.getIntegerInput(1);
			Operator v2 = Algorithm.getIntegerInput(2);
			Operator v3 = Algorithm.getIntegerInput(3);
			Operator oTrue = Algorithm.getConst("true", "boolean");
			Operator oFalse = Algorithm.getConst("false", "boolean");
			gen.operators.add(v1);
			gen.operators.add(v2);
			gen.operators.add(v3);
			gen.operators.add(oTrue);
			gen.operators.add(oFalse);
			Type type = new Type();
			type.kind = "void";
			type.var = false;
			type.ref = "";
			Algorithm a = Algorithm.randomAlgorithmCount(gen, type, 0, 10);
			String str = a.asString();
			textView.setText(str);
		} catch (Exception e) {
			textView.setText("error:" + e.getMessage());
		}
	}
	
	public void onClick(View v) {
		OpenFileDialog fileDialog = new OpenFileDialog(this);
		fileDialog.setFilter(".*\\.xml");
		fileDialog.setOpenDialogListener(this);
		fileDialog.show();
	}
}
