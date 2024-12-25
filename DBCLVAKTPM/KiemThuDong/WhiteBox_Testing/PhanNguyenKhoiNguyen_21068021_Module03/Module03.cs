using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PhanNguyenKhoiNguyen_21068021_Module03
{
    public class Module03
    {
        //Bai 01
        public int GetPositionOf2Cir(int firstRadius, int secRadius, int distance)
        {
            if (distance == 0)
            {
                if (firstRadius == secRadius)
                {
                    return 0;
                }
                else if (firstRadius < secRadius)
                {
                    return 1;
                }
                else
                {
                    return 2;
                }

            }
            else if (distance > 0)
            {
                return 3;
            }
            else
            {
                return 0;
            }

        }

        //Bai 02
        public String bai02(int X, int Y, int Z)
        {
            if (X == 1 || X == 2)
            {
                return "A";
            }
            else
            {
                if (Y <= 10)
                {
                    return "B";
                }
                else
                {
                    if (Z < 5)
                    {
                        return "C";
                    }
                    else
                    {
                        return "D";
                    }
                }
            }
        }

        //Bai 03
        public int MaxAndMean(int A, int B, int C, out double Mean)
        {
            Mean = (A + B + C) / 3.0;
            int Maximum;
            if (A > B)
            {
                if (A > C)
                    Maximum = A;
                else
                    Maximum = B;
            }
            else
            {
                if (B > C)
                    Maximum = B;
                else
                    Maximum = C;
            }
            return Maximum;
        }
        //Bai 04
        public int Max(int a, int b, int c)
        {
            int max = 0;
            if (a > 0 && b > 0 && c > 0)
                max = a;
            else
                return 0;
            if (max < b)
                max = b;
            if (max < c)
                max = c;
            return max;
        }
        //Bai 05
        public String Triangle(int a, int b, int c)
        {
            int match = 0;
            if (a == b)
                match = match + 1;
            if (a == c)
                match = match + 2;
            if (b == c)
                match = match + 3;
            if (match == 0)
                if ((a + b) <= c)
                    return ("Not a Triangle");
                else if ((b + c) <= a)
                    return ("Not a Triangle");
                else if ((a + c) <= b)
                    return ("Not a Triangle");
                else return ("Triangle is Scalene");
            else if (match == 1)
                if ((a + c) <= b)
                    return ("Not a Triangle");
                else return ("Triangle is Isosceles");
            else if (match == 2)
                if ((a + c) <= b)
                    return ("Not a Triangle");
                else return ("Triangle is Isosceles");
            else if (match == 3)
                if ((b + c) <= a)
                    return ("Not a Triangle");
                else return ("Triangle is Isosceles");
            else return ("Triangle is Equilateral");
        }
        //Bai 06
        public double Average(double Sum, double Count)
        {
            if (Count == 1) return Sum;
            else if (Count > 0) return Sum / Count;
            else return 0;
        }
        //Bai 07
        public Byte DayinMonth(byte month, ushort year)

        {
            switch (month)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    {
                        return 31;
                        break;
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    {
                        return 30;
                        break;
                    }
                case 2:
                    {
                        if (year % 400 == 0)
                        {
                            return 29;
                        }
                        else if (year % 100 == 0)
                        {
                            return 28;
                        }
                        else if (year % 4 == 0)
                        {
                            return 28;
                        }
                        else
                        {
                            return 29;
                        }
                        break;
                    }

                default:
                    {
                        return 0;
                        break;
                    }

            }
        }
        //Bai 08
        public String bai08(float a, float b, float c, out float x1, out float x2)
        {
            String loi;
            float delta = 0;
            if (a != 0)
            {
                delta = b * b - 4 * a * c;
                if (delta < 0)
                {
                    x1 = x2 = 0;
                    return "no_result";
                }
                else if (delta == 0)
                {
                    x1= -b / (2 * a);
                    x2 = x1;
                    return $"x1 = x2 = {x1}";
                }
                else
                {
                    x1 = (-b - (float)Math.Sqrt(delta)) / (2 * a);
                    x2 = (-b + (float)Math.Sqrt(delta)) / (2 * a);
                    return $"x1 = {x1}, x2 = {x2}";
                }
            }
            else
            {
                x1 = x2 = 0;
                return "error";
            }
        }
        //Bai 09
        public float bai09(float a, float b, float x)
        {
            if (a > b)
            {
                throw new AccessViolationException("");
            }
            else
            {
                if (x < a)
                {
                    return a;
                }
                else
                {
                    if (x > b)
                    {
                        return b;
                    }
                    else
                    {
                        return x;
                    }
                }
            }
        }
        //Bai 10
        public bool bai10(float a, float b, float c)
        {
            if (!(a <= 0 || b <= 0 || c <= 0))
            {
                if ((a + b) > c)
                {
                    if ((a + c) > b)
                    {
                        if ((b + c) > a)
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        //Bai 11
        public void bai11(out float x, out float y, float w, float h, float ww, float wh)
        {
            if(w <= 0 || h <= 0 || ww <= 0 || wh <= 0)
            {
                throw new ArgumentOutOfRangeException("w, h, ww, wh không được  <= 0");
            }
            else
            {
                if(w > ww)
                {
                    x = 0;
                }
                else
                {
                    x =(ww - w) / 2;
                }

                if(h > wh)
                {
                    y = 0;
                }
                else
                {
                    y = (wh - h) / 2;
                }
            }
        }
        //Bai 12
        public float tienNuoc(float p1, float p2, float p3,float total)
        {
            if(p1 < 0 || p2 <0 ||p3 < 0 || total < 0)
            {
                throw new ArgumentOutOfRangeException("Tham so nhap vao khong hop le");
            }
            else
            {
                if(total <= 100)
                {
                    return total * p1;
                }
                else if (total <= 150)
                {
                    return 100 * p1 + (total - 100) * p2;
                }
                else
                {
                    return 100 * p1 + 50 * p2 + (total - 150) * p3;
                }
            }
        }
        //Bai 13
        public bool kiemTraXY_HCN(float x1, float y1, float x2, float y2, float x, float y)
        {
            if (x1 > x2 || y1 > y2)
            {
                throw new ArgumentOutOfRangeException("Tham so nhap vao khong hop le x1 >= x2 va y1 >= y2");
            }
            else
            {
                if (x < x1 || x > x2)
                {
                    return false;
                }
                else
                {
                    if(y < y1 || y > y2)
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
            }
        }
        //Bai 14
        public void Icon(float w, float h, out float s, out float x, out float y)
        {
            if (w < 0 || h < 0)
            {
                throw new ArgumentOutOfRangeException("Khog duoc nho hon 0");
            }
            else
            {
                if (w > h)
                {
                    x = (w - h) / 2;
                    y = 0;
                    s = h;
                }
                else
                {
                    x = 0;
                    y = (h - w) / 2;
                    s = w;
                }
            }
        }

        //Bai 15
        public bool checkYear(int year)
        {
            if(year > 10000 || year < 1000)
            {
                return false;
            }
            else
            {
                if(year % 100 == 0)
                {
                    if(year % 400 ==0)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else if(year % 4 == 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        //Bai 16
        public bool PasswordCheck(String pass)
        {
            if(pass.Length >= 6 && pass.Length <= 10 && pass.Any(char.IsDigit))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        //Bai 17
        public bool IsValidDate(short Year, byte Month, byte Day)
        {
            if(Month >= 1 && Month <= 12)
            {
                if(Day >= 1)
                {
                    if (Day <= DateTime.DaysInMonth(Year,Month))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        //Bai 18
        public bool EmailCheck(String email)
        {
            if (email.Contains('.'))
            {
                if (email.Contains(".."))
                {
                    return false;
                }
                else if (email.Contains("@"))
                {
                    if (email.Contains("@.") || email.Contains(".@") || email.Contains("@@"))
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        //Bai 19
        public int BodyCheck(short height, int weight)
        {
            double scale;
            if(height <= 0)
            {
                return -1;
            }
            else
            {
                if(weight <= 0)
                {
                    return -1;
                }
                else
                {
                    scale = weight * 10000 / (height * height);
                    if(scale < 18)
                    {
                        return 2;
                    }else if(scale > 20)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        }
        //Bai 20
        static readonly int MAX_INT = 32767;
        static char[] str = "Statement Coverage".ToCharArray();
        public int isInString(char tmp)
        {
            int pos = MAX_INT;
            int i = 0;
            while(str[i] != '\0')
            //while(i < str.Length)
            {
                if(str[i] == tmp)
                {
                    pos = i;
                    break;
                }
                i++;
            }
            return pos;

        }
        //Bai 21
        public long HexToDec(string hexaString)
        {
            int c;
            long hexnum, nhex;
            hexnum = nhex = 0;
            int i = 0;
            while (i < hexaString.Length)
            {
                c = hexaString[i++];
                switch (c)
                {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        /* Convert a decimal digit */
                        nhex++;
                        hexnum *= 0x10;
                        hexnum += (c - '0');
                        break;
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                    case 'f':
                        /* lower case hex digit */
                        nhex++;
                        hexnum *= 0x10;
                        hexnum += (c - 'a' + 0xa);
                        break;
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                        /*upper case hex digit */
                        nhex++;
                        hexnum *= 0x10;
                        hexnum += (c - 'A' + 0xA);
                        break;
                    default:
                        /* non-hex characters */
                        break;
                }
            }
            return hexnum;
        }
    }
}

