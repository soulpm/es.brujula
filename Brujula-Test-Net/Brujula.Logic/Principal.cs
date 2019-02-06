using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Brujula.Logic
{
    public class Principal
    {

        private List<Figura> GetFiguras()
        {
            List<Figura> figuras = new List<Figura>();
            figuras.Add(new Triangulo());
            figuras.Add(new Rectangulo());
            figuras.Add(new Triangulo());
            figuras.Add(new Rectangulo());
            figuras.Add(new Rombo());
            return figuras;
        }

        private void GetFiguraTypeCuadrado()
        {
            foreach (var item in GetFiguras())
            {
                if (item.GetType().BaseType.Name.Equals(new Cuadrado().GetType().Name))
                { item.pintar(); }
            }
        }
        private void GetFiguraTypeTriangulo()
        {
            foreach (var item in GetFiguras())
            {
                if (item.GetType().Name.Equals(new Triangulo().GetType().Name))
                { item.pintar(); }
            }
        }

        public void ImprimirReporte()
        {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Recorriendo Figuras: ");
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("1er Recorrido Figuras de tipo Cuadrado:");
            Console.ForegroundColor = ConsoleColor.White;
            GetFiguraTypeCuadrado();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("2do Recorrido Figuras de tipo Triangulo:");
            Console.ForegroundColor = ConsoleColor.White;
            GetFiguraTypeTriangulo();
            Console.ReadLine();

        }

    }
}
