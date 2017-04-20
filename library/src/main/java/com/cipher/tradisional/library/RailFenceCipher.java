package com.cipher.tradisional.library;

/**
 * @author : hafiq on 20/04/2017.
 */

public class RailFenceCipher {

    private static String whiteSpaceReplacement = "X";
    private static boolean previewLogFence = false;

    public static void setWhiteSpaceReplacement(String whiteSpaceReplacement) {
        RailFenceCipher.whiteSpaceReplacement = whiteSpaceReplacement;
    }

    public static void setPreviewLogFence(boolean previewLogFence) {
        RailFenceCipher.previewLogFence = previewLogFence;
    }

    public static String RFEncryption(int key, String text) {
        int move = 1;
        int count = 0;
        String[][] rfp = new String[key][text.length()];

        // arrange dot fence
        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                rfp[x][y] = ".";
            }
        }

        // formatting according fence rails
        for (int i = 0; i < text.length(); i++) {
            if ((move % 2) != 0) {
                rfp[count][i] = "" + text.charAt(i);
                if (count == (key - 1)) {
                    move = 2;
                    count = (key - 2);
                } else
                    count++;
            } else if ((move % 2) == 0) {
                rfp[count][i] = "" + text.charAt(i);
                if (count == 0) {
                    move = 1;
                    count = 1;
                } else
                    count--;
            }

        }

        //replace any white space with X or random
        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                if (rfp[x][y].equals(" "))
                    rfp[x][y] = whiteSpaceReplacement;
            }
        }

        if (previewLogFence) {
            System.out.println();
            for (String[] aRfp : rfp) {
                for (String anARfp : aRfp) {
                    System.out.print(anARfp + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        StringBuilder cb = new StringBuilder();
        //encode string from fence
        for (String[] aRfp : rfp) {
            for (String anARfp : aRfp) {
                if (!".".equals(anARfp)) {
                    cb.append(anARfp);
                }
            }
        }

        return "" + cb;
    }

    // without key
    public static String[] RFDecryptNoKey(String text) {

        String[] ans = new String[text.length() - 2];
        for (int z = 2; z < text.length(); z++) {
            String[][] rfp = new String[z][text.length()];

            for (int x = 0; x < rfp.length; x++) {
                for (int y = 0; y < rfp[x].length; y++) {
                    rfp[x][y] = ".";
                }
            }

            // arrange accroding to fence rail
            int count = 0;
            int c;
            int a, b;
            int init = (2 * z) - 2;
            a = init - 2;
            b = 2;
            for (int i = 0; i < rfp.length; i++) {
                c = 0;
                for (int u = i; u < rfp[i].length;) {
                    if (count != text.length()) {
                        if (i == 0 || i == z - 1) {
                            rfp[i][u] = "" + text.charAt(count);
                            u = u + init;
                        } else {
                            rfp[i][u] = "" + text.charAt(count);
                            if (c % 2 == 0)
                                u = u + a;
                            else if (c % 2 == 1)
                                u = u + b;
                            c++;
                        }
                        count++;
                    } else
                        break;

                }
                if (i != 0 && i != z - 1) {
                    a = a - 2;
                    b = b + 2;
                }
            }

            int move = 1;
            count = 0;
            String sb = "";
            for (int i = 0; i < text.length(); i++) {
                if ((move % 2) != 0) {
                    sb = sb + rfp[count][i];
                    if (count == (z - 1)) {
                        move = 2;
                        count = (z - 2);
                    } else
                        count++;
                } else if ((move % 2) == 0) {
                    sb = sb + rfp[count][i];
                    if (count == 0) {
                        move = 1;
                        count = 1;
                    } else
                        count--;
                }

            }

            ans[z - 2] = sb;
        }
        return ans;
    }

    public static String RFDecryptWithKey(String text, int key) {
        String[][] rfp = new String[key][text.length()];

        for (int x = 0; x < rfp.length; x++) {
            for (int y = 0; y < rfp[x].length; y++) {
                rfp[x][y] = ".";
            }
        }

        // arrange accroding to fence rail
        int count = 0;
        int c;
        int a, b;
        int init = (2 * key) - 2;
        a = init - 2;
        b = 2;
        for (int i = 0; i < rfp.length; i++) {
            c = 0;
            for (int u = i; u < rfp[i].length;) {
                if (count != text.length()) {
                    if (i == 0 || i == key - 1) {
                        rfp[i][u] = "" + text.charAt(count);
                        u = u + init;
                    } else {
                        rfp[i][u] = "" + text.charAt(count);
                        if (c % 2 == 0)
                            u = u + a;
                        else if (c % 2 == 1)
                            u = u + b;
                        c++;
                    }
                    count++;
                } else
                    break;

            }
            if (i != 0 && i != key - 1) {
                a = a - 2;
                b = b + 2;
            }
        }

        if (previewLogFence) {
            System.out.println("\n\nDecrypting..list into table");
            for (String[] aRfp : rfp) {
                for (String anARfp : aRfp) {
                    System.out.print(anARfp + " ");
                }
                System.out.println();
            }
        }

        int move = 1;
        count = 0;
        String sb = "";
        for (int i = 0; i < text.length(); i++) {
            if ((move % 2) != 0) {
                sb = sb + rfp[count][i];
                if (count == (key - 1)) {
                    move = 2;
                    count = (key - 2);
                } else
                    count++;
            } else if ((move % 2) == 0) {
                sb = sb + rfp[count][i];
                if (count == 0) {
                    move = 1;
                    count = 1;
                } else
                    count--;
            }

        }

        return sb;
    }
}
