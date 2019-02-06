using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Brujula.Logic
{
    public class Triangulo:Figura
    {
        override public void pintar()
        {
            Console.WriteLine(this.GetType().Name);
        }
    }
}
