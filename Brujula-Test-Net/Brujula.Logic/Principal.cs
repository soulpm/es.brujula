using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Brujula.Logic
{
    public class Principal
    {
        private string figuraTipo { get; set; }

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
            figuraTipo = new Cuadrado().GetType().Name;
            PrintTypeFigura(figuraTipo);
            foreach (var item in GetFiguras())
            {
                if (item.GetType().BaseType.Name.Equals(figuraTipo))
                { item.pintar(); }
            }
        }
        private void GetFiguraTypeTriangulo()
        {
            figuraTipo = new Triangulo().GetType().Name;
            PrintTypeFigura(figuraTipo);
            foreach (var item in GetFiguras())
            {
                if (item.GetType().Name.Equals(new Triangulo().GetType().Name))
                { item.pintar(); }
            }
        }

        private void PrintTypeFigura(string typeFigure) {
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("Recorrido Figuras de tipo "+typeFigure+": ");
            Console.ForegroundColor = ConsoleColor.White;
        }

        public void ImprimirReporte()
        {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("Recorriendo Figuras: ");
            Console.ForegroundColor = ConsoleColor.White;
            GetFiguraTypeCuadrado();
            Console.ForegroundColor = ConsoleColor.White;
            GetFiguraTypeTriangulo();
            Console.ReadLine();
        }

    }
}
