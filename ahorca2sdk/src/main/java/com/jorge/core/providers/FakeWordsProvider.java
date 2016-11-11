package com.jorge.core.providers;

import com.jorge.core.Ahorca2Words;
import com.jorge.core.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 10/11/2016.
 */

public class FakeWordsProvider implements WordsProvider {

    @Override
    public Ahorca2Words getWords() {
        return words.get(random());
    }

    public int random() {
//        ThreadLocalRandom.current().nextInt(0, words.size());
        return (int) (Math.random()*words.size());
    }

    List<Ahorca2Words> words = new ArrayList<Ahorca2Words>(){{
        add(new Ahorca2Words(new Word("Sleet"), new Word("Aguanieve")));
        add(new Ahorca2Words(new Word("Hang out"), new Word("pasar el rato")));
        add(new Ahorca2Words(new Word("Far apart on"), new Word("muy divididos")));
        add(new Ahorca2Words(new Word("Outcome"), new Word("resultado")));
        add(new Ahorca2Words(new Word("Ruling"), new Word("governante, fallo, sentencia")));
        add(new Ahorca2Words(new Word("Overall goal"), new Word("objetivo principal")));
//        add(new Ahorca2Words(new Word("Lost seats"), new Word("perder escaños")));
//        add(new Ahorca2Words(new Word("Has been blamed for"), new Word("ha sido culpable de")));
//        add(new Ahorca2Words(new Word("Blizzard"), new Word("tormenta de nieve")));
//        add(new Ahorca2Words(new Word("Unleashed"), new Word("desató")));
//        add(new Ahorca2Words(new Word("Brace"), new Word("prepararse")));
//        add(new Ahorca2Words(new Word("Crowded"), new Word("Lleno de gente")));
//        add(new Ahorca2Words(new Word("Am I guessing != I am guessing "), new Word(" lo voy pillando/adivinando")));
//        add(new Ahorca2Words(new Word("Let me guess"), new Word("Déjame adivinar")));
//        add(new Ahorca2Words(new Word("Let me know"), new Word("Quiero saber")));
//        add(new Ahorca2Words(new Word("Let me see"), new Word("Déjame ver")));
//        add(new Ahorca2Words(new Word("Kind of"), new Word("Más o menos")));
//        add(new Ahorca2Words(new Word("Close"), new Word("Próximo")));
//        add(new Ahorca2Words(new Word("Catchy"), new Word("Pegadizo, fácil de recordar")));
//        add(new Ahorca2Words(new Word("Conscience, awareness"), new Word("Conciencia")));
//        add(new Ahorca2Words(new Word("Aware, conscious"), new Word("Consciente")));
//        add(new Ahorca2Words(new Word("Unbidden"), new Word("Espontáneo, no invitado")));
//        add(new Ahorca2Words(new Word("Can't get out of your head"), new Word("No puedes sacarlo de tu cabeza")));
//        add(new Ahorca2Words(new Word("Target"), new Word("Objetivo, blanco")));
//        add(new Ahorca2Words(new Word("Both"), new Word("Ambos")));
//        add(new Ahorca2Words(new Word("Endeavour"), new Word("Esfuerzo, esforzarse")));
//        add(new Ahorca2Words(new Word("Meanness"), new Word("Mezquindad, maldad")));
//        add(new Ahorca2Words(new Word("Evenly"), new Word("Igualmente")));
//        add(new Ahorca2Words(new Word("Teardown"), new Word("Demoler, deshacer")));
//        add(new Ahorca2Words(new Word("Nest"), new Word("Nido")));
//        add(new Ahorca2Words(new Word("Nested"), new Word("Anidada, dentro de otra cosa")));
//        add(new Ahorca2Words(new Word("Aim"), new Word("Objetivo, meta, apuntar, dirigir")));
//        add(new Ahorca2Words(new Word("Breathe deep"), new Word("Respira profundo")));
//        add(new Ahorca2Words(new Word("Troubleshooting"), new Word("Solución de problemas")));
//        add(new Ahorca2Words(new Word("Mishap"), new Word("Accidente, desgracia")));
//        add(new Ahorca2Words(new Word("Early"), new Word("Temprano")));
//        add(new Ahorca2Words(new Word("Reliable"), new Word("Fiable, seguro")));
//        add(new Ahorca2Words(new Word("We face"), new Word("Nos enfrentamos")));
//        add(new Ahorca2Words(new Word("Argument"), new Word("Discusión")));
//        add(new Ahorca2Words(new Word("Despite"), new Word("A pesar de")));
//        add(new Ahorca2Words(new Word("Yours faithfully"), new Word("Atentamente")));
//        add(new Ahorca2Words(new Word("So far"), new Word("Hasta ahora")));
//        add(new Ahorca2Words(new Word("Borrow"), new Word("Pedir, tomar prestado")));
//        add(new Ahorca2Words(new Word("Underneath"), new Word("bajo, al alcance, por la parte inferior")));
//        add(new Ahorca2Words(new Word("Whereas"), new Word("Mientras que")));
//        add(new Ahorca2Words(new Word("Behavior"), new Word("Comportamiento, conducta")));
//        add(new Ahorca2Words(new Word("Narrow-minded"), new Word("De mente estrecha")));
//        add(new Ahorca2Words(new Word("Greet"), new Word("Saludar, felicitar")));
//        add(new Ahorca2Words(new Word("Clerk"), new Word("Dependiente")));
//        add(new Ahorca2Words(new Word("Citizen"), new Word("Ciudadano")));
//        add(new Ahorca2Words(new Word("Outgoing"), new Word("Extrovertido, abierto")));
//        add(new Ahorca2Words(new Word("Trait"), new Word("Rasgo, característica")));
//        add(new Ahorca2Words(new Word("Selfish"), new Word("Egoísta")));
//        add(new Ahorca2Words(new Word("Hook"), new Word("Gancho")));
//        add(new Ahorca2Words(new Word("Avoid"), new Word("Evitar")));
//        add(new Ahorca2Words(new Word("Nasty"), new Word("Repugnante")));
//        add(new Ahorca2Words(new Word("Arise"), new Word("Surgir")));
//        add(new Ahorca2Words(new Word("Fulfill"), new Word("Cumplir")));
//        add(new Ahorca2Words(new Word("Forgive"), new Word("Perdonar")));
//        add(new Ahorca2Words(new Word("Deal"), new Word("Repartir")));
//        add(new Ahorca2Words(new Word("Matter"), new Word("Importar, materia")));
//        add(new Ahorca2Words(new Word("Along with"), new Word("Junto con")));
//        add(new Ahorca2Words(new Word("Achieve"), new Word("Lograr")));
//        add(new Ahorca2Words(new Word("Therefore"), new Word("Por lo tanto")));
//        add(new Ahorca2Words(new Word("Overlook"), new Word("Examinar, pasar por alto")));
//        add(new Ahorca2Words(new Word("Within"), new Word("Dentro")));
//        add(new Ahorca2Words(new Word("Such"), new Word("Tal")));
//        add(new Ahorca2Words(new Word("As"), new Word("Como")));
//        add(new Ahorca2Words(new Word("Alongside"), new Word("Junto a")));
//        add(new Ahorca2Words(new Word("Deal"), new Word("Repartir, encargarse")));
//        add(new Ahorca2Words(new Word("Demerit"), new Word("Desmérito")));
//        add(new Ahorca2Words(new Word("DrawBack"), new Word("Desventaja, inconveniente")));
//        add(new Ahorca2Words(new Word("Hold"), new Word("Mantener, soportar")));
//        add(new Ahorca2Words(new Word("Hold on!"), new Word("ánimo!, resiste")));
//        add(new Ahorca2Words(new Word("Pretty"), new Word("Bastante")));
//        add(new Ahorca2Words(new Word("Pretty much"), new Word("Más o menos")));
//        add(new Ahorca2Words(new Word("And so on"), new Word("Y demás, etcétera")));
//        add(new Ahorca2Words(new Word("Meanwhile"), new Word("Mientras tanto")));
//        add(new Ahorca2Words(new Word("Glad"), new Word("Contento, alegre")));
//        add(new Ahorca2Words(new Word("Damn it!"), new Word("¡Maldita sea!")));
//        add(new Ahorca2Words(new Word("Blast you!"), new Word("¡Qué maravilla!")));
//        add(new Ahorca2Words(new Word("Awful"), new Word("Horrible, terrible")));
//        add(new Ahorca2Words(new Word("Blow up"), new Word("Volar, inflar, explotar")));
//        add(new Ahorca2Words(new Word("Caveat"), new Word("Advertencia")));
//        add(new Ahorca2Words(new Word("Indeed"), new Word("En efecto, ¡Ya lo creo!")));
//        add(new Ahorca2Words(new Word("Either as"), new Word("Ya sea como")));
//        add(new Ahorca2Words(new Word("Prone"), new Word("Propenso")));
//        add(new Ahorca2Words(new Word("Empower"), new Word("Permite")));
//        add(new Ahorca2Words(new Word("Afford"), new Word("Permitir")));
//        add(new Ahorca2Words(new Word("Wise"), new Word("Sabio")));
//        add(new Ahorca2Words(new Word("Punch"), new Word("Fuerza, golpear")));
//        add(new Ahorca2Words(new Word("To let"), new Word("Permitir, poder")));
//        add(new Ahorca2Words(new Word("Investment"), new Word("Inversión")));
//        add(new Ahorca2Words(new Word("Figure out"), new Word("Hacerse una idea, resolver")));
//        add(new Ahorca2Words(new Word("Aside"), new Word("Aparte")));
//        add(new Ahorca2Words(new Word("Nifty"), new Word("Elegante")));
//        add(new Ahorca2Words(new Word("Overwhelming"), new Word("Contundente, abrumador")));
//        add(new Ahorca2Words(new Word("Spread"), new Word("Difundir, propagarse, extenderse")));
//        add(new Ahorca2Words(new Word("Get along"), new Word("Llevarse bien")));
//        add(new Ahorca2Words(new Word("Evolve"), new Word("Evolucionar")));
//        add(new Ahorca2Words(new Word("Loose"), new Word("Flojo, suelto")));
//        add(new Ahorca2Words(new Word("A matter of"), new Word("Una cuestión de")));
//        add(new Ahorca2Words(new Word("Strength"), new Word("Fuerza, solidez")));
//        add(new Ahorca2Words(new Word("Myriad"), new Word("Infinidad")));
//        add(new Ahorca2Words(new Word("Grab"), new Word("Coger, agarrar")));
//        add(new Ahorca2Words(new Word("Rely"), new Word("Depender, confiar")));
//        add(new Ahorca2Words(new Word("Stuff"), new Word("Cosas, meter, taponar")));
//        add(new Ahorca2Words(new Word("Give away"), new Word("Regalar")));
//        add(new Ahorca2Words(new Word("Huge Mess"), new Word("Gran lío")));
//        add(new Ahorca2Words(new Word("Clumsy"), new Word("Torpe")));
//        add(new Ahorca2Words(new Word("Rotten"), new Word("Podrido")));
//        add(new Ahorca2Words(new Word("Spoil"), new Word("Estropear")));
//        add(new Ahorca2Words(new Word("For the sake of"), new Word("Por el bien de")));
//        add(new Ahorca2Words(new Word("Tough"), new Word("Duro, malo")));
//        add(new Ahorca2Words(new Word("Skill"), new Word("Habilidad, destreza")));
//        add(new Ahorca2Words(new Word("Shall be placed"), new Word("Debería ser situado")));
//        add(new Ahorca2Words(new Word("As for"), new Word("En cuanto a")));
//        add(new Ahorca2Words(new Word("Dig"), new Word("Cavar, excabación")));
//        add(new Ahorca2Words(new Word("Or so"), new Word("más o menos")));
//        add(new Ahorca2Words(new Word("Getting rid"), new Word("Deshacerse")));
//        add(new Ahorca2Words(new Word("As well"), new Word("También")));
//        add(new Ahorca2Words(new Word("Anyhow"), new Word("De todos modos")));
//        add(new Ahorca2Words(new Word("Gist"), new Word("Esencia")));
//        add(new Ahorca2Words(new Word("Wisdom"), new Word("Sabiduría")));
//        add(new Ahorca2Words(new Word("Behalf"), new Word("Favor")));
//        add(new Ahorca2Words(new Word("So bear with me"), new Word("Tengan paciencia conmigo, sopórtenme")));
//        add(new Ahorca2Words(new Word("Awkward"), new Word("Incómodo")));
//        add(new Ahorca2Words(new Word("Yardstick"), new Word("Criterio, vara de medir")));
//        add(new Ahorca2Words(new Word("Cringe"), new Word("Miedo, encogerse")));
//        add(new Ahorca2Words(new Word("Hodgepodge"), new Word("Batiburrillo, cajón de sastre")));
//        add(new Ahorca2Words(new Word("Winding"), new Word("Tortuoso, serpenteante (carretera)")));
//        add(new Ahorca2Words(new Word("Seldom"), new Word("Raramente, pocas veces")));
//        add(new Ahorca2Words(new Word("Chase"), new Word("Perseguir")));
//        add(new Ahorca2Words(new Word("Grinds my gears"), new Word("Sacar de mis casillas")));
//        add(new Ahorca2Words(new Word("Don't hold your breath"), new Word("No te hagas ilusiones")));
//        add(new Ahorca2Words(new Word("Ancillary"), new Word("Secundario, auxiliar")));
//        add(new Ahorca2Words(new Word("Gibberish"), new Word("Hablar sin sentido ")));
//        add(new Ahorca2Words(new Word("Sorrow, Pain"), new Word("Dolor")));
//        add(new Ahorca2Words(new Word("Whim"), new Word("Capricho, antojo")));
//        add(new Ahorca2Words(new Word("Shiny"), new Word("Brillante, lustroso")));
//        add(new Ahorca2Words(new Word("Suppressed"), new Word("Suprimido, reprimido")));
//        add(new Ahorca2Words(new Word("Lenient"), new Word("Indulgente, tolerante")));
//        add(new Ahorca2Words(new Word("Nitty-gritty"), new Word("Nucleo, tema central")));
//        add(new Ahorca2Words(new Word("Weak"), new Word("Débil")));
//        add(new Ahorca2Words(new Word("Noteworthy"), new Word("Considerable")));
//        add(new Ahorca2Words(new Word("Elide"), new Word("Suprimir")));
    }};
}
