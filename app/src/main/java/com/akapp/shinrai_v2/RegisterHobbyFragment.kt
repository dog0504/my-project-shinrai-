package com.akapp.shinrai_v2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterHobbyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterHobbyFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_register_hobby, container, false)
    }

    //画面遷移処理
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //エディットテキスト入力ボックス
        val editText = view.findViewById<EditText>(R.id.edit_lover_hobby)

        // ボタンを追加するコンテナを取得
        val buttonContainer = view.findViewById<LinearLayout>(R.id.hobby_list_button_container)

        // ボタンのラベルをリストとして定義
        val buttonLabels = listOf("運動","勉強","読書","ランニング","ロマンス映画","JPOP","KPOP","POP")

        //　FragmentMangerの取得
        val rhf = parentFragmentManager

        //　トランザクションの生成・コミット
        val fm = rhf.beginTransaction()

        //　必要な要素をActivityから取得
        val frontButton = requireActivity().findViewById<Button>(R.id.front)
        val nextButton = requireActivity().findViewById<Button>(R.id.next)


        editText.setOnEditorActionListener{ _, _, _ ->
            val input_hobby_Text = editText.text.toString().trim()//入力したテキスト取得
            if(input_hobby_Text.isNotEmpty()){
                addHobbyButton(input_hobby_Text, buttonContainer) // ボタンを追加
                editText.text.clear() // 入力をクリア
                true
            }else{
                false
            }
        }

        for(label in buttonLabels){
            val personality_button = Button(requireContext()).apply{
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
            personality_button.setOnClickListener{
                //クリックイベントの処理
                println("Clicked: $label")
            }

            buttonContainer.addView(personality_button)
        }

        frontButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterMbtiFragment())
                commit()
            }
        }

        nextButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterConfirmFragment())
                commit()
            }
        }



    }

    //ボタンを追加するメソッド
    private fun addHobbyButton(text: String, container: LinearLayout) {
        val hobbyButton = Button(requireContext()).apply{
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                //　ボタン間の余白を設定
                setMargins(20,10,20,10)
            }
            this.text = text //ボタンのテキストを設定
            textSize = 16f
            setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            setBackgroundResource(R.drawable.bt_gender_selection) // 背景をカスタム
        }
        // ボタンクリック時の動作を設定
        hobbyButton.setOnClickListener {
            // ボタンのクリックイベント
            println("Clicked: $text")
        }

        // コンテナにボタンを追加
        container.addView(hobbyButton)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterHobbyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterHobbyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}