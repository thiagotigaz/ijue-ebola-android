package app.ijueebola.supercloud.com.br.ijueebola.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.ijueebola.supercloud.com.br.ijueebola.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link app.ijueebola.supercloud.com.br.ijueebola.fragment.FragmentTips#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTips extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
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
        containerLinearLayout = (LinearLayout) view.findViewById(R.id.tips_container);
        setupTips(containerLinearLayout);
        return view;
    }

    private void setupTips(LinearLayout containerLinearLayout) {
        String[] faq = getResources().getStringArray(R.array.tips);
        String[] faqAnswers = getResources().getStringArray(R.array.tip_answers);
        for(int i = 0;i<faq.length;i++){
            TextView question = new TextView(getActivity());
            question.setText(i+1+". "+ faq[i]);
            question.setTypeface(null, Typeface.BOLD);
            TextView answer = new TextView(getActivity());
            answer.setText(faqAnswers[i]+"\n");
            containerLinearLayout.addView(question);
            containerLinearLayout.addView(answer);
        }
    }
}
