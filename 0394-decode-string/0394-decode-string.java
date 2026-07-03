class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> st = new Stack<>();
        int i=0;
        int n=s.length();

       
            

            while(i<n){
                int k=0;
                
                 while (i<n&&s.charAt(i)!=']') {
                    char ch=s.charAt(i);
                if (Character.isDigit(ch)) {
                    k=k*10+(ch-'0');
                   
                }
                else{
                    if(ch=='['){
                         num.push(k);
                        k=0;
                    }
                    st.push(Character.toString(ch));
                }
                i++;
            }
            StringBuilder sb= new StringBuilder();

            while(!st.isEmpty()&&!st.peek().equals("[")){
                sb.append(st.pop());
            }
            String rep=sb.toString();
            if(!st.isEmpty()){

            st.pop();
            }
            int iter=1;
            if(!num.isEmpty()){

            iter=num.pop();
            }

            for(int m=1;m<=iter-1;m++){
                sb.append(rep);
            }

            st.push(sb.toString());
            i++;



            }
            StringBuilder ans= new StringBuilder();

            while(!st.isEmpty()){
                ans.append(st.pop());
            }

            return ans.reverse().toString();
           
        }

    }
