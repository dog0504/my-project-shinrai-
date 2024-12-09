package com.akapp.shinrai_v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterPersonalityFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterPersonalityFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_register_personality, container, false)
    }

    //Fragment画面遷移のために、onViewCreated宣言
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //FragmentMangerの取得
        val rpf = parentFragmentManager
        //トランザクションの生成・コミット
        val fm = rpf.beginTransaction()

        //　必要な要素を取得
        val frontButton = requireActivity().findViewById<Button>(R.id.front)
        val nextButton = requireActivity().findViewById<Button>(R.id.next)

        // 取得したボタンのクリックリスナー（front)
        frontButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterBloodTypeFragment())
                commit()
            }
        }

        // 取得したボタンのクリックリスナー(next)
        nextButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterMbtiFragment())
                commit()
            }
        }
        //必要なViewを取得
        val editText = view.findViewById<EditText>(R.id.edit_lover_personality)
        val buttonContainer = view.findViewById<LinearLayout>(R.id.personality_list_button_container)

        //EditTextでenterキーを押した際にボタンを追加
        editText.setOnEditorActionListener { _, _, _ ->
            val input_Personality_Text = editText.text.toString().trim() //入力したテキスト取得
            if(input_Personality_Text.isNotEmpty()) {
                addButton(input_Personality_Text, buttonContainer) //ボタンを追加
                editText.text.clear() // 入力内容をクリア
                true // イベントを消費し、システムのデフォルト動作を無効化
            }else{
                Toast.makeText(requireContext(), "テキストを入力してください", Toast.LENGTH_SHORT).show()
                // イベントを消費しない（ここでは特に動作無し）
                // 入力が空の場合、システムのデフォルト動作を許可
                false
            }
        }
    }
    
    // ボタンを動的に追加するメソッド
    private fun addButton(text: String, container: LinearLayout) {
        val button = Button(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(10, 10, 10, 10) // マージンを追加
            }
            this.text = text
            textSize = 16f
            setOnClickListener {
                Toast.makeText(requireContext(), "$text がクリックされました", Toast.LENGTH_SHORT).show()
            }
        }
        container.addView(button) // ボタンをコンテナに追加
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterPersonalityFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterPersonalityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}