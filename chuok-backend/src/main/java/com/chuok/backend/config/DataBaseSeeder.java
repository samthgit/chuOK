package com.chuok.backend.config;

import com.chuok.backend.model.Level;
import com.chuok.backend.model.World;
import com.chuok.backend.repository.LevelRepository;
import com.chuok.backend.repository.WorldRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataBaseSeeder {

    private final WorldRepository worldRepository;
    private final LevelRepository levelRepository;

    @PostConstruct
    public void seedDatabase() {
        // Seed only if database is empty (to prevent duplicates on app restarts)
        if (worldRepository.count() == 0) {
            createWorld("Literature", 1, worldRepository);
            createWorld("Science", 2, worldRepository);
            createWorld("Nature", 3, worldRepository);
        }

        if (levelRepository.count() == 0) {
            List<World> worlds = worldRepository.findAll();
            World literature = worlds.stream().filter(w -> w.getName().equals("Literature")).findFirst().orElse(null);
            World science = worlds.stream().filter(w -> w.getName().equals("Science")).findFirst().orElse(null);
            World nature = worlds.stream().filter(w -> w.getName().equals("Nature")).findFirst().orElse(null);

            if (literature != null && science != null && nature != null) {
                levelRepository.saveAll(List.of(
                        newLevel(1, "Who wrote *Pride and Prejudice*?", "Jane Austen", "Charlotte Brontë", "Emily Dickinson", "Mary Shelley", 1, literature),
                        newLevel(2, "Which novel begins with the line 'Call me Ishmael'?", "The Great Gatsby", "Moby Dick", "Frankenstein", "Dracula", 2, literature),
                        newLevel(3, "Who is the author of *1984*?", "George Orwell", "Aldous Huxley", "Ray Bradbury", "Jules Verne", 1, literature),
                        newLevel(4, "What is the name of Sherlock Holmes' assistant?", "Moriarty", "Hudson", "Watson", "Mycroft", 3, literature),
                        newLevel(5, "In which play do Rosencrantz and Guildenstern appear?", "Hamlet", "Macbeth", "King Lear", "Othello", 1, literature),
                        newLevel(6, "Atticus Finch is a character in which novel?", "The Catcher in the Rye", "Of Mice and Men", "To Kill a Mockingbird", "The Grapes of Wrath", 3, literature),
                        newLevel(7, "Who wrote *The Divine Comedy*?", "Homer", "Virgil", "Dante Alighieri", "Petrarch", 3, literature),
                        newLevel(8, "Who is the author of *One Hundred Years of Solitude*?", "Mario Vargas Llosa", "Gabriel García Márquez", "Pablo Neruda", "Isabel Allende", 2, literature),
                        newLevel(9, "Which book features the dystopian society of Panem?", "Divergent", "The Hunger Games", "Brave New World", "Fahrenheit 451", 2, literature),
                        newLevel(10, "*Dracula* by Bram Stoker belongs to which genre?", "Fantasy", "Science Fiction", "Horror", "Romance", 3, literature),
                        newLevel(11, "Who created Middle-earth?", "George R.R. Martin", "Terry Pratchett", "J.R.R. Tolkien", "C.S. Lewis", 3, literature),
                        newLevel(12, "Who wrote *The Picture of Dorian Gray*?", "Oscar Wilde", "Charles Dickens", "Mark Twain", "Edgar Allan Poe", 1, literature),
                        newLevel(13, "In which novel does Humbert Humbert appear?", "Lolita", "Crime and Punishment", "Anna Karenina", "The Stranger", 1, literature),
                        newLevel(14, "Who wrote *Les Misérables*?", "Victor Hugo", "Honoré de Balzac", "Émile Zola", "Gustave Flaubert", 1, literature),
                        newLevel(15, "Which novel is about a man turned into an insect?", "The Trial", "Notes from Underground", "The Metamorphosis", "The Plague", 3, literature),
                        newLevel(16, "Who wrote *The Iliad* and *The Odyssey*?", "Socrates", "Homer", "Plato", "Euripides", 2, literature),
                        newLevel(17, "Which Brontë sister wrote *Wuthering Heights*?", "Charlotte", "Emily", "Anne", "None", 2, literature),
                        newLevel(18, "What is the name of the whale in *Moby Dick*?", "Nemo", "Moby Dick", "Ishmael", "Queequeg", 2, literature),
                        newLevel(19, "What burns at 451°F in Bradbury’s novel?", "Books", "Plastic", "Wood", "Metal", 1, literature),
                        newLevel(20, "Who wrote *Crime and Punishment*?", "Leo Tolstoy", "Anton Chekhov", "Fyodor Dostoevsky", "Maxim Gorky", 3, literature),

                        // Science questions
                        newLevel(1, "What is the chemical symbol for water?", "H₂O", "CO₂", "O₂", "NaCl", 1, science),
                        newLevel(2, "Which planet is known as the Red Planet?", "Mars", "Venus", "Jupiter", "Mercury", 1, science),
                        newLevel(3, "What gas do plants absorb from the atmosphere?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen", 2, science),
                        newLevel(4, "What is the speed of light?", "150,000 km/s", "300,000 km/s", "30,000 km/s", "3,000 km/s", 2, science),
                        newLevel(5, "Who developed the theory of relativity?", "Newton", "Einstein", "Tesla", "Galileo", 2, science),
                        newLevel(6, "What is the center of an atom called?", "Electron", "Proton", "Nucleus", "Neutron", 3, science),
                        newLevel(7, "Which cell part contains DNA?", "Ribosome", "Nucleus", "Cytoplasm", "Cell membrane", 2, science),
                        newLevel(8, "Which cells fight infection?", "Red blood cells", "White blood cells", "Platelets", "Stem cells", 2, science),
                        newLevel(9, "What force keeps planets in orbit?", "Magnetism", "Inertia", "Friction", "Gravity", 4, science),
                        newLevel(10, "What is the most abundant gas in Earth's atmosphere?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", 2, science),
                        newLevel(11, "Which planet has the most moons?", "Earth", "Jupiter", "Saturn", "Uranus", 3, science),
                        newLevel(12, "Which unit measures electric current?", "Volt", "Ohm", "Ampere", "Watt", 3, science),
                        newLevel(13, "Which organ pumps blood?", "Liver", "Heart", "Kidney", "Lung", 2, science),
                        newLevel(14, "Which organ produces insulin?", "Liver", "Pancreas", "Stomach", "Intestine", 2, science),
                        newLevel(15, "What process lets plants make food?", "Respiration", "Digestion", "Photosynthesis", "Fermentation", 3, science),
                        newLevel(16, "What is the basic unit of life?", "Atom", "Molecule", "Organ", "Cell", 4, science),
                        newLevel(17, "Which of these is a noble gas?", "Oxygen", "Argon", "Hydrogen", "Carbon", 2, science),
                        newLevel(18, "Who is considered the father of modern physics?", "Einstein", "Galileo", "Newton", "Maxwell", 3, science),
                        newLevel(19, "What vitamin does sunlight help produce?", "A", "B", "C", "D", 4, science),
                        newLevel(20, "What is the formula for table salt?", "NaCl", "HCl", "KCl", "CaCO₃", 1, science),

                        // Nature questions
                        newLevel(1, "Which tree produces acorns?", "Pine", "Birch", "Oak", "Maple", 3, nature),
                        newLevel(2, "What is the largest land animal?", "Giraffe", "Rhino", "Elephant", "Hippo", 3, nature),
                        newLevel(3, "Which bird is known to mimic sounds?", "Crow", "Eagle", "Parrot", "Sparrow", 3, nature),
                        newLevel(4, "What is a baby frog called?", "Tadpole", "Froglet", "Pollywog", "Spawn", 1, nature),
                        newLevel(5, "What do bees collect from flowers?", "Pollen", "Dew", "Nectar", "Honey", 3, nature),
                        newLevel(6, "Which flower symbolizes peace?", "Rose", "Lily", "Olive", "Tulip", 3, nature),
                        newLevel(7, "Which season follows summer?", "Spring", "Fall", "Winter", "Monsoon", 2, nature),
                        newLevel(8, "Which insect produces silk?", "Silkworm", "Bee", "Ant", "Butterfly", 1, nature),
                        newLevel(9, "Where do polar bears live?", "South Pole", "North Pole", "Greenland", "Siberia", 2, nature),
                        newLevel(10, "Which animal changes color to blend in?", "Iguana", "Frog", "Chameleon", "Gecko", 3, nature),
                        newLevel(11, "What type of animal is a frog?", "Reptile", "Amphibian", "Mammal", "Bird", 2, nature),
                        newLevel(12, "What type of plant is bamboo?", "Tree", "Grass", "Shrub", "Fern", 2, nature),
                        newLevel(13, "Which planet is closest to the sun?", "Venus", "Earth", "Mercury", "Mars", 3, nature),
                        newLevel(14, "Which rock type forms from lava?", "Sedimentary", "Igneous", "Metamorphic", "Fossil", 2, nature),
                        newLevel(15, "What is the largest ocean?", "Atlantic", "Indian", "Arctic", "Pacific", 4, nature),
                        newLevel(16, "What gas do animals exhale?", "Oxygen", "Carbon Dioxide", "Nitrogen", "Helium", 2, nature),
                        newLevel(17, "What type of animal is a koala?", "Rodent", "Reptile", "Marsupial", "Primate", 3, nature),
                        newLevel(18, "Which part of the plant does photosynthesis?", "Root", "Stem", "Leaf", "Flower", 3, nature),
                        newLevel(19, "What is the fastest land animal?", "Cheetah", "Lion", "Horse", "Gazelle", 1, nature),
                        newLevel(20, "What do we call animals that eat only plants?", "Carnivores", "Omnivores", "Herbivores", "Detritivores", 3, nature)
                ));
            } else {
                throw new IllegalStateException("Worlds not found for seeding levels");
            }
        }
    }

    private World createWorld(String name, int order, WorldRepository worldRepository) {
        World world = new World();
        world.setName(name);
        world.setOrderIndex(order);
        return worldRepository.save(world);
    }

    private Level newLevel(int number, String question, String op1, String op2, String op3, String op4, int correct, World world) {
        Level level = new Level();
        level.setLevelNumber(number);
        level.setQuestion(question);
        level.setOption1(op1);
        level.setOption2(op2);
        level.setOption3(op3);
        level.setOption4(op4);
        level.setCorrectIndex(correct);
        level.setWorld(world);
        return level;
    }
}

