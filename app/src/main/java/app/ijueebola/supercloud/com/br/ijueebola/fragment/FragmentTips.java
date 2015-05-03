package app.ijueebola.supercloud.com.br.ijueebola.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

import app.ijueebola.supercloud.com.br.ijueebola.R;
import app.ijueebola.supercloud.com.br.ijueebola.helper.ArticleBuilder;
import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link app.ijueebola.supercloud.com.br.ijueebola.fragment.FragmentTips#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTips extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @InjectView(R.id.tips_container)
    LinearLayout containerLinearLayout;


    public FragmentTips() {
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
    public static FragmentTips newInstance(String param1, String param2) {
        FragmentTips fragment = new FragmentTips();
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
        View view = inflater.inflate(R.layout.fragment_tips, container, false);
        ButterKnife.inject(this, view);
//        addDocumentView(getContent(), DocumentView.PLAIN_TEXT);
//        DocumentView documentView = new DocumentView(getActivity(),DocumentView.FORMATTED_TEXT);
//        documentView.setText(getContentString());
//        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
//        documentView.getDocumentLayoutParams().setAntialias(true);
        TextView textView = new TextView(getActivity());
        textView.setText(Html.fromHtml(getContentString()));
        textView.setTextColor(getResources().getColor(R.color.colorContentText));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f);
        containerLinearLayout.addView(textView);
        return view;
    }

    private ArticleBuilder getContent() {
        String[] tips = getResources().getStringArray(R.array.tips);
        String[] tipAnswers = getResources().getStringArray(R.array.tip_answers);
        ArticleBuilder ab = new ArticleBuilder();
        for (int i = 0; i < tips.length; i++) {
            ab.append(i + 1 + ". " + tips[i], true);
            ab.append(tipAnswers[i], true);
        }
        return ab;
    }

    private String getContentString() {
        String[] tips = getResources().getStringArray(R.array.tips);
        String[] tipAnswers = getResources().getStringArray(R.array.tip_answers);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tips.length; i++) {
            sb.append( i + 1 + ". " + tips[i]+"<br/><br/>");
            sb.append(tipAnswers[i]+"<br/><br/>");
        }
        return sb.toString();
    }

    public DocumentView addDocumentView(CharSequence article, int type, boolean rtl) {
        final DocumentView documentView = new DocumentView(getActivity(), type);
        documentView.getDocumentLayoutParams().setTextColor(getResources().getColor(R.color.colorContentText));
        documentView.getDocumentLayoutParams().setTextTypeface(Typeface.DEFAULT);
        documentView.getDocumentLayoutParams().setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView.getDocumentLayoutParams().setInsetPaddingLeft(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingRight(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingTop(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingBottom(30f);
        documentView.getDocumentLayoutParams().setLineHeightMultiplier(1f);
        documentView.getDocumentLayoutParams().setReverse(rtl);
        documentView.setText(article);
        documentView.setFadeInDuration(500);
        documentView.setFadeInAnimationStepDelay(30);
        documentView.setFadeInTween(new DocumentView.ITween() {
            @Override
            public float get(float t, float b, float c, float d) {
                return c * (t /= d) * t * t + b;
            }
        });
        containerLinearLayout.addView(documentView);
        return documentView;
    }

    public DocumentView addDocumentView(CharSequence article, int type) {
        return addDocumentView(article, type, false);
    }
}
