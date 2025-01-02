package com.akapp.shinrai_v2

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.security.Key

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterMbtiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterMbtiFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_register_mbti, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fragmentの取得
        val mfm = parentFragmentManager

        //トランザクションの生成・コミット
        val fm = mfm.beginTransaction()

        // 必要な要素をactivityから取得
        val frontButton = requireActivity().findViewById<Button>(R.id.front) //前へボタン
        val nextButton = requireActivity().findViewById<Button>(R.id.next) //次へボタン

        //　必要な要素をfragmentから取得
        val editText = view.findViewById<EditText>(R.id.edit_lover_id)
        val frameLayout = view.findViewById<FrameLayout>(R.id.frame_lover_mbti_color)
        val imageView = view.findViewById<ImageView>(R.id.image_lover_mbti_type)
        val textView = view.findViewById<TextView>(R.id.text_lover_mbti_type)

        // 初期状態でフレームレイアウトを非表示にする
        frameLayout.visibility = View.GONE

        //　Enterキー押下時のリスナー設定(IME_ACTION_SEARCHなどのactionを設定しておく)
        editText.setOnEditorActionListener { v, actionid, event ->
            if(actionid == EditorInfo.IME_ACTION_SEARCH ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)){

                val inputMbti = editText.text.toString().trim().uppercase()
                //　入力値に基づく処理例
                //　MBTIタイプに応じた画像や背景drawableを定義済みのマップから取得することを想定
                val mbtiData = MbtiResourceMap[inputMbti]

                if (mbtiData != null){

                    // 入力値が有効な場合は、フレームを表示させる
                    frameLayout.visibility = View.VISIBLE

                    //　画像・フレーム背景設定
                    frameLayout.setBackgroundResource(mbtiData.frameDrawableRes)
                    imageView.setImageResource(mbtiData.imageRes)
                    textView.setText(mbtiData.displayName)
                }else{

                    //　入力値が無効な場合は、フレームを非表示にさせる
                    frameLayout.visibility = View.GONE
                    // 対応するMBTIタイプがない場合のハンドリング
                    Toast.makeText(requireContext(), "対応するMBTIが見つかりません", Toast.LENGTH_SHORT).show()
                }
                true
            }else{
                false
            }
        }
        // 取得したボタンのクリックリスナー
        frontButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterPersonalityFragment())
                commit()
            }
        }

        nextButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterHobbyFragment())
                commit()
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterMbtiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterMbtiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}