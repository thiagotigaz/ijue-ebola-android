package app.ijueebola.supercloud.com.br.ijueebola.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.ijueebola.supercloud.com.br.ijueebola.R;
import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link FragmentAbout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAbout extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayout containerLinearLayout;

//    @InjectView(R.id.aboutTextView)
//    TextView aboutTextView;
    @InjectView(R.id.textViewGithub)
    TextView githubTextView;
    @InjectView(R.id.textViewFacebook)
    TextView facebookTextView;
    @InjectView(R.id.textViewTwitter)
    TextView twetterTextView;
    @InjectView(R.id.aboutWebView)
    WebView aboutWebView;

    public FragmentAbout() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSearch.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAbout newInstance(String param1, String param2) {
        FragmentAbout fragment = new FragmentAbout();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.inject(this, view);
//        aboutTextView.setText(Html.fromHtml(getString(R.string.about_content)));
        String core = "<html><body style='text-align:justify;color:rgba(%s);font-size:%dpx;'>%s</body></html>";
//        aboutWebView.loadData(getString(R.string.about_content_html), "text/html", "utf-8");
        aboutWebView.setWebChromeClient(new WebChromeClient() { });
        aboutWebView.loadData(String.format(core, "#333", 14, getString(R.string.about_content_html)), "text/html", "utf-8");
        setAwesomeIcon("\uf092", githubTextView, R.color.colorGithubIcon);
        setAwesomeIcon("\uf082", facebookTextView, R.color.colorFacebookIcon);
        setAwesomeIcon("\uf081", twetterTextView, R.color.colorTwetterIcon);
        return view;
    }

    private void setAwesomeIcon(String unicode, TextView textView, int iconColor) {
        Typeface fontFamily = Typeface.createFromAsset(getResources().getAssets(), "fonts/fontawesome-webfont.ttf");
        textView.setTypeface(fontFamily);
        textView.setText(unicode);
        textView.setTextColor(getResources().getColor(iconColor));
    }


}
