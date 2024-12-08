package com.akapp.shinrai_v2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterBloodTypeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterBloodTypeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_blood_type, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //FragmentMangerの取得
        val rbtfm = parentFragmentManager

        //トランザクションの生成・コミット
        val fm = rbtfm.beginTransaction()

        //　ボタンをデザインを配置するコンテナを取得
        val buttonContainer = view.findViewById<LinearLayout>(R.id.dynamic_button_container)

        //　配列でボタンのラベルを管理
        val buttonLabels = listOf("A型","B型","O型","AB型")

        //　必要な要素を取得
        val frontButton = requireActivity().findViewById<Button>(R.id.front)
        val nextButton = requireActivity().findViewById<Button>(R.id.next)

        frontButton.setOnClickListener{
            fm.apply{
                replace(R.id.fragmentContainerView, RegisterGenderFragment())
                commit()
            }
        }
        nextButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterPersonalityFragment())
                commit()
            }
        }

        //ボタンを動的に追加
        for(label in buttonLabels){
            val button = Button(requireActivity()).apply{
                text = label

                //LinearLayout.LayoutParams(幅、高さ)
                //レイアウト設定（幅、高さ、マージン）
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply{
                    //setMargins(left, top, right, bottom)
                    setMargins(20, 10, 20, 10)
                }
                textSize = 16f
                setTextColor(Color.parseColor("#000000"))
                setBackgroundResource(R.drawable.bt_gender_selection)
            }
            //ボタンクリック時の動作を設定
            button.setOnClickListener{
                //クリックイベントの処理
                println("Clicked: $label")
            }

            buttonContainer.addView(button)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterBloodTypeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterBloodTypeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}