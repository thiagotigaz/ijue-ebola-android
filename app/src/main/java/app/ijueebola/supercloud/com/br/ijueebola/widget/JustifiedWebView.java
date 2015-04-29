package app.ijueebola.supercloud.com.br.ijueebola.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by thiago on 4/25/15.
 */
public class JustifiedWebView extends WebView {

    private String core = "<html><body style='text-align:justify;color:rgba(%s);font-size:%dpx;'>%s</body></html>";
    private String textColor = "0,0,0,255";
    private String text = "";
    private int textSize = 12;
    private int backgroundColor = Color.TRANSPARENT;

    public JustifiedWebView(Context context) {
        super(context);
        this.setWebChromeClient(new WebChromeClient() {

        });

    }

    public JustifiedWebView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setWebChromeClient(new WebChromeClient() {
        });
    }

    public void setText(String s) {
        this.text = s;
        // this.setPadding(10, 10, 10, 10);
        reloadData();
    }

    @SuppressLint("NewApi")
    private void reloadData() {

        // loadData(...) has a bug showing utf-8 correctly. That's why we need
        // to set it first.
        this.getSettings().setDefaultTextEncodingName("utf-8");

        this.loadData(String.format(core, textColor, textSize, text),
                "text/html", "utf-8");

        // set WebView's background color *after* data was loaded.
//        super.setBackgroundColor(backgroundColor);
        // Hardware rendering breaks background color to work as expected.
        // Need to use software renderer in that case.
        if (android.os.Build.VERSION.SDK_INT >= 11)
            this.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
    }

    public void setTextColor(int hex) {
        String h = Integer.toHexString(hex);
        int a = Integer.parseInt(h.substring(0, 2), 16);
        int r = Integer.parseInt(h.substring(2, 4), 16);
        int g = Integer.parseInt(h.substring(4, 6), 16);
        int b = Integer.parseInt(h.substring(6, 8), 16);
        textColor = String.format("%d,%d,%d,%d", r, g, b, a);
        reloadData();
    }

    public void setBackgroundColor(int hex) {
        backgroundColor = hex;
        reloadData();
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        reloadData();
    }

}
