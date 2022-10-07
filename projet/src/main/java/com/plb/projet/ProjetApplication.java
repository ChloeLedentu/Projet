package com.plb.projet;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.plb.projet.model.Book;
import com.plb.projet.model.Borrow;
import com.plb.projet.model.Cd;
import com.plb.projet.model.CdTitle;
import com.plb.projet.model.Dvd;
import com.plb.projet.model.Item;
import com.plb.projet.model.Member;
import com.plb.projet.repository.BookRepository;
import com.plb.projet.repository.BorrowRepository;
import com.plb.projet.repository.CdRepository;
import com.plb.projet.repository.DvdRepository;
import com.plb.projet.repository.ItemRepository;
import com.plb.projet.repository.MemberRepository;

@SpringBootApplication
public class ProjetApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProjetApplication.class);
        ConfigurableEnvironment environment = new StandardEnvironment();
        environment.setDefaultProfiles("dev");
        application.setEnvironment(environment);
        application.run(args);
    }

    @Bean
    public CommandLineRunner createData(MemberRepository memberRepository, ItemRepository itemRepository,
            CdRepository cdRepository, DvdRepository dvdRepository, BookRepository bookRepository,
            BorrowRepository borrowRepository) {
        return args -> {

            // create member
            Member member1 = new Member("daniel@gmail.com", "Jean", "daniel", "sa", 0, "user", null);
            memberRepository.save(member1);

            Member admin1 = new Member("admin@gmail.com", "", "admin", "admin", 0, "admin", null);
            memberRepository.save(admin1);

            // create Cd

            Cd cd1 = new Cd("Metallica", "Black",
                    "Après le succès des éditions Super Deluxe de Kill’ Em All, Ride the Lightning, Master Of Puppets ...And Justice For All voici le très attendu Black Album."
                            + "\n" +
                            "De mémoire de fans jamais le contenu d’une édition Super Deluxe n’a été aussi riche. Avec 6 vinyles, 14 CD, 5 DVD, un hardbook, un poster, et des pins."
                            + "\n" +
                            "Le groupe a bien sûr remasterisé l’album, mais il a surtout plongé dans les archives pour nous offrir de nombreux enregistrements et captations vidéo, inédits à ce jour."
                            + "\n" +
                            "Ces témoignages rendent compte de la vie du groupe en studio à l’époque de l’enregistrement de l’album, mais également de leur incroyable présence scénique à travers les live inédits.",
                    null, LocalDate.now(), LocalDate.of(1991, 8, 13), 4, null, 12, null);
            Cd cd2 = new Cd("Florent Pagny", "Ailleurs land",
                    "Ailleurs land est le 8e album studio de Florent Pagny et son 10e album discographique, sorti le 8 avril 2003 chez Mercury France, sous la direction artistique de Bertrand Lamblot."
                            + "\n"
                            + "Enregistré en Patagonie (pour les voix) où Pagny a élu domicile, cet album est précédé d'une polémique à propos du premier single qui en est extrait : Ma liberté de penser. Son auteur, Lionel Florence y énumère tout ce que le fisc peut saisir, c'est-à-dire tout, sauf sa liberté de penser. Néanmoins, la chanson est un succès immédiat.",
                    null, LocalDate.now(), LocalDate.of(2003, 4, 8), 6, null, 11, null);
            Cd cd3 = new Cd("Ariana Grande", "Positions",
                    "Positions est le sixième album studio de la chanteuse américaine Ariana Grande, publié le 30 octobre 2020 par Republic Records2. Cet album fait suite à K Bye For Now (SWT Live), son dernier projet musical et Thank U, Next, son dernier album sorti en 2019."
                            + "\n"
                            + "L'album aborde des thématiques autour du sexe et inclus des collaborations avec Doja Cat, The Weeknd et Ty Dolla $ign.",
                    null, LocalDate.now(), LocalDate.of(2020, 10, 30), 6, null, 14, null);
            Cd cd4 = new Cd("Black pink", "Born Pink",
                    "Born Pink est le deuxième album complet du girl group sud-coréen Blackpink, officiellement sorti le 16 septembre 2022 à 13 heures (heure coréenne) et produit par YG Entertainment. La sortie de l'album était accompagnée par celle du clip vidéo de la chanson principale, Shut Down.",
                    null, LocalDate.now(), LocalDate.of(2022, 9, 22), 8, null, 11, null);

            cdRepository.save(cd1);
            cdRepository.save(cd2);
            cdRepository.save(cd3);
            cdRepository.save(cd4);

            // create Dvd
            Dvd dvd1 = new Dvd("Joe Russo", "Avengers: Endgame",
                    "Thanos ayant anéanti la moitié de l’univers, les Avengers restants resserrent les rangs dans ce vingt-deuxième film des Studios Marvel, grande conclusion d’un des chapitres de l’Univers Cinématographique Marvel.",
                    null, LocalDate.now(), LocalDate.of(2019, 8, 30), 3, null, 181, "Blu-ray");
            Dvd dvd2 = new Dvd("Roger Allers", "Le roi lion",
                    "Sur les hautes terres d'Afrique règne Mufasa, lion tout-puissant respecté et admiré pour sa grande sagesse et sa générosité. Son jeune fils Simba insouciant et turbulent doit lui succéder un jour."
                            + "\n"
                            + " Mais Scar, l'oncle jaloux du lionceau élabore un plan qui l'obligera à s'enfuir.",
                    null, LocalDate.now(), LocalDate.of(2011, 8, 24), 5, null, 84, "Dvd");
            Dvd dvd3 = new Dvd("Francis Veber", "Tais toi !",
                    "Ruby n'a qu'une idée en tête : se venger de l'homme qui a assassiné la femme qu'il aimait.Quentin n'a en tête que très peu de neurones. Juste assez pour être d'une grande gentillesse et d'une bêtise à entrer dans le Livre des Records."
                            + "\n"
                            + "Les chemins des deux hommes vont se croiser, celui du dur qui n'est que désir de meurtre et celui du simple qui tutoie les anges.La gentillesse catastrophique de Quentin parviendra-t-elle à désamorcer la violence meurtrière de Ruby, c'est le sujet de Tais-toi !",
                    null, LocalDate.now(), LocalDate.of(2019, 12, 1), 2, null, 85, "Dvd");
            Dvd dvd4 = new Dvd("Steven Spielberg", "Les dents de la mer",
                    "A quelques jours du début de la saison estivale, les habitants de la petite station balnéaire d'Amity sont mis en émoi par la découverte sur le littoral du corps atrocement mutilé d'une jeune vacancière."
                            + "\n"
                            + " Pour Martin Brody, le chef de la police, il ne fait aucun doute que la jeune fille a été victime d'un requin. Il décide alors d'interdire l'accès des plages mais se heurte à l'hostilité du maire uniquement intéressé par l'afflux des touristes. Pendant ce temps, le requin continue à semer la terreur le long des côtes et à dévorer les baigneurs.",
                    null, LocalDate.now(), LocalDate.of(2022, 6, 22), 2, null, 123, "Blu-ray 4K");
            dvdRepository.save(dvd1);
            dvdRepository.save(dvd2);
            dvdRepository.save(dvd3);
            dvdRepository.save(dvd4);

            // create Book
            Book book1 = new Book("J.K. Rowling", "Harry Potter à l'école des sorciers",
                    "Lorsqu'il n'était encore qu'un bébé, les parents de Harry Potter furent tués par un sorcier puissant. Ayant miraculeusement survécu à cette attaque, Harry n'en n'a gardé qu'une cicatrice sur le front et a été adopté par sa tante et son horrible famille. "
                            + "\n"
                            + "Des années plus tard, alors qu'Harry apprend tout de ses véritables racines et rentre en première année de sorcellerie à Poudlard (l'école des sorciers), sa cicatrice se réveille...",
                    null, LocalDate.now(), LocalDate.of(2017, 10, 12), 6, null, 2075145938l);
            Book book2 = new Book("Stephen King", "Sleeping Beauties",
                    "Un phénomène inexplicable touche les femmes sur toute la planète : une sorte de cocon les enveloppe durant leur sommeil, et si l'on tente de les réveiller, on prend le risque de les transformer en véritables furies. Bientôt, presque toutes sont touchées par la fièvre Aurora, et le monde est livré à la violence masculine."
                            + "\n"
                            + " À Dooling, petite ville des Appalaches, la mystérieuse Evie semble immunisée contre cette épidémie. Cas d'étude pour la science ou créature démoniaque, échappera-t-elle à la fureur des hommes privés soudainement de femmes ?",
                    null, LocalDate.now(), LocalDate.of(2019, 9, 4), 2, null, 2226400222l);
            Book book3 = new Book("Robert C. Martin", "Coder proprement",
                    "Le point sur les pratiques pour nettoyer un code. Après une description des principes, des motifs et des pratiques employés dans l'écriture d'un code propre, des études de cas présentent différents exercices de nettoyage.",
                    null, LocalDate.now(), LocalDate.of(2019, 4, 5), 3, null, 232600227l);
            Book book4 = new Book("Miguel Ruiz", "Les quatre accords toltèques",
                    "Castaneda a fait découvrir au grand public les enseignements des chamans mexicains qui ont pour origine la tradition toltèque, gardienne des connaissances de Quetzacoatl, le serpent à plumes."
                            + "\n"
                            + "Dans ce livre, Don Miguel révèle la source des croyances limi-tatrices qui nous privent de joie et créent des souffrances inutiles. Il montre en des termes très simples comment on peut se libérer du conditionnement collectif - le rêve de la planète, basé sur la peur - afin de retrouver la dimension d'a mour inconditionnel qui est à notre origine et constitue le fondement de s enseignements toltèques."
                            + "\n"
                            + "Les quatre accords proposent un puissant code de conduite capable de transformer rapidement notre vie en une expérience de liberté, de vrai bonheur et d'amour. Le monde fascinant de la Connaissance véritable et incarnée est enfin à la portée de chacun.",
                    null, LocalDate.now(), LocalDate.of(2016, 1, 8), 2, null, 2889116549l);
            Book book5 = new Book("Christian Jacq", "L'Égypte pharaonique",
                    "Issu de plus d'un demi-siècle de recherches, cet ouvrage, illustré de documents remarquables, dont beaucoup rares et peu connus, tente de comprendre comment L'Égypte pharaonique a façonné l'âme du monde et accompli l'impossible mariage entre l'esprit et la matière."
                            + "\n"
                            + "Avec son incroyable talent de narrateur, Christian Jacq redonne vie à cet univers qui parle à tous les êtres et continue, à travers les siècles, à  transmettre des valeurs fondamentales, sans lesquelles une société cède au chaos et à la violence."
                            + "\n"
                            + " Un passionnant voyage dans le temps pour découvrir les clés de cette civilisation de lumière : l'univers spirituel (dieux et les divinités), la politique (fonctionnement de l'état pharaonique), l'économie, la vie quotidienne et sa sacralisation.",
                    null, LocalDate.now(), LocalDate.of(2022, 10, 19), 1, null, 2376713358l);

            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
            bookRepository.save(book5);

        };
    }
}
