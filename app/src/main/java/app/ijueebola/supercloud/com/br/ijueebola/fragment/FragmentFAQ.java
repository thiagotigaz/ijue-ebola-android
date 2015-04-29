package app.ijueebola.supercloud.com.br.ijueebola.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import app.ijueebola.supercloud.com.br.ijueebola.R;
import app.ijueebola.supercloud.com.br.ijueebola.logging.L;
import app.ijueebola.supercloud.com.br.ijueebola.widget.JustifiedWebView;
import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link FragmentFAQ#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFAQ extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @InjectView(R.id.faq_container)
    LinearLayout containerLinearLayout;
//    @InjectView(R.id.faqWebView)
//    JustifiedWebView faqWebView;

    public FragmentFAQ() {
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
    public static FragmentFAQ newInstance(String param1, String param2) {
        FragmentFAQ fragment = new FragmentFAQ();
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
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        ButterKnife.inject(this, view);
//        faqWebView.setText(getContent());
        return view;
    }

    private String getContent() {
        StringBuilder sb = new StringBuilder();
        String[] faq = getResources().getStringArray(R.array.faq);
        String[] faqAnswers = getResources().getStringArray(R.array.faq_answers);
        for(int i = 0;i<faq.length;i++){
//            sb.append(i+1+". "+ faq[i]);
//            sb.append(faqAnswers[i]);
            /*TextView question = new TextView(getActivity());
            question.setText(i+1+". "+ faq[i]);
            question.setTypeface(null, Typeface.BOLD);
            TextView answer = new TextView(getActivity());
            answer.setText(Html.fromHtml(faqAnswers[i]));
            containerLinearLayout.addView(question);
            containerLinearLayout.addView(answer);*/
            JustifiedWebView myMsg = new JustifiedWebView(getActivity());
            myMsg.setVerticalScrollBarEnabled(false);
            myMsg.setText(i+1+". "+ faq[i] + faqAnswers[i]);
            containerLinearLayout.addView(myMsg);
        }
        L.m(sb.toString());
        return sb.toString();
    }
}
