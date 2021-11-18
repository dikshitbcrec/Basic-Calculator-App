package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Stack;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    StringBuilder S=new StringBuilder();
    public void AC(View view) {
        S.delete(0,S.length());
        disp(S);
    }
    public void One(View view)
    {
        S.append("1");
        disp(S);
    }
    public void Two(View view)
    {
        S.append("2");
        disp(S);
    }
    public void Three(View view)
    {
        S.append("3");
        disp(S);
    }
    public void Four(View view)
    {
        S.append("4");
        disp(S);
    }
    public void Five(View view)
    {
        S.append("5");
        disp(S);
    }
    public void Six(View view)
    {
        S.append("6");
        disp(S);
    }
    public void Seven(View view)
    {
        S.append("7");
        disp(S);
    }
    public void Eight(View view)
    {
        S.append("8");
        disp(S);
    }
    public void Nine(View view)
    {
        S.append("9");
        disp(S);
    }
    public void Zero1(View view)
    {
            S.append("0");
            disp(S);
    }

    /*private void error(StringBuilder s) {
        TextView d= (TextView)findViewById(R.id.text1);
        d.setText("Invalid");
    }*/

    public void Add(View view)
    {
        S.append("+");
        disp(S);
    }
    public void subt(View view)
    {
        S.append("%");
        disp(S);
    }
    public void Sub(View view)
    {
        S.append("-");
        disp(S);
    }
    public void Into(View view)
    {
        S.append("*");
        disp(S);
    }
    public void divide(View view)
    {
        S.append("/");
        disp(S);
    }
    public void dell(View view)
    {
        if(S.length()>0)
            S.deleteCharAt(S.length()-1);

        disp(S);
    }
    public void Rbr(View view)
    {
        S.append(")");
        disp(S);
    }
    public void Lbr(View view)
    {
        S.append("(");
        disp(S);
    }

    public void Equ(View view)
    {
       String k=logic(S.toString());
        StringBuilder l=new StringBuilder(k);
        disp1(l);
    }

    private void disp1(StringBuilder l)
    {
        TextView d= (TextView)findViewById(R.id.text1);
        d.setText("= "+l);

    }
        static class Pair{
        Stack<Integer> st;
        char sign;
        Pair(Stack<Integer>s,char si)
        {
            st=s;
            sign=si;
        }
        }
    private String logic(String s) {
        char sign='+';
        Stack<Pair>stP= new Stack<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                int val=0;
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                {
                    val = val* 10+ (s.charAt(i)-'0');
                    i++;
                }
                i--;
                cal(st,val,sign);

            }
            else if(ch=='(')
            {
                stP.push(new Pair(st,sign));
                sign='+';
                st= new Stack<>();
            }
            else if(ch==')')
            {
                int val=0;
                while(st.size()>0)
                {
                    val+=st.pop();
                }
                Pair p= stP.pop();
                st=p.st;
                sign=p.sign;
                cal(st,val,sign);
            }
            else if(ch!=' ')
            {
                sign=ch;
            }

        }
        int ans=0;
        for(int i=st.size();i>0;i--)
        {
            ans+=st.pop();
        }
        return String.valueOf(ans);

    }

    private void cal(Stack<Integer> st, int val, char sign) {
        if(sign=='+')
            st.push(val);
        else if(sign=='-')
            st.push(-val);
        else if(sign=='*')
        {
            int ans=st.pop();
            int a=ans*val;
            st.push(a);
        }
        else if(sign=='/')
        {
            int ans=st.pop();
            int a=ans/val;
            st.push(a);
        }
    }

    private void disp(StringBuilder s) {
        TextView d= (TextView)findViewById(R.id.text1);
        d.setText(s);
    }

}