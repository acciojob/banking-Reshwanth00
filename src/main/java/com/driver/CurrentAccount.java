package com.driver;
class ValidLicense extends Exception{
    ValidLicense(){
        super("Valid License can not be generated");
    }
}
public class CurrentAccount extends BankAccount {
    String tradeLicenseId;
    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        if(balance<5000){
            throw new Insufficient();
        }
        this.tradeLicenseId=tradeLicenseId;
    }
    private boolean consecutive() {
        for(int i=0;i<this.tradeLicenseId.length()-1;i++){
            if(this.tradeLicenseId.charAt(i)==this.tradeLicenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
    public char getMaxCountChar(int[] count){
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)((int)'a' + i);
            }
        }
        return ch;
    }
    public String rearrangeString(String S) {
        int N = S.length();
        if (N == 0)
            return "";
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (char ch : S.toCharArray()) {
            count[(int)ch - (int)'a']++;
        }
        char ch_max = getMaxCountChar(count);
        int maxCount = count[(int)ch_max - (int)'a'];
        if (maxCount > (N + 1) / 2)
            return "";
        String res = "";
        for (int i = 0; i < N; i++) {
            res += ' ';
        }
        int ind = 0;
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max
                    + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        count[(int)ch_max - (int)'a'] = 0;
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= N) ? 1 : ind;
                res = res.substring(0, ind)
                        + (char)((int)'a' + i)
                        + res.substring(ind + 1);
                ind += 2;
                count[i]--;
            }
        }
        return res;
    }
    public void validateLicenseId() throws Exception {
        if(!consecutive()) {
            this.tradeLicenseId  = rearrangeString(this.tradeLicenseId.toLowerCase()).toUpperCase();
            if(this.tradeLicenseId==null || this.tradeLicenseId.length()==0){
                throw new ValidLicense();
            }
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
