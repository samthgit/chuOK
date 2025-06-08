package com.chuok.backend.config;

import com.chuok.backend.model.*;
import com.chuok.backend.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

/**
 * Configuration class responsible for seeding the database with initial data.
 * Seeds Worlds, Levels, Articles, and Phrases if the corresponding tables are empty.
 * This helps provide default content for the application on first run.
 */
@Configuration
@RequiredArgsConstructor
public class DataBaseSeeder {

    /** Repository for World entities. */
    private final WorldRepository worldRepository;
    /** Repository for Level entities. */
    private final LevelRepository levelRepository;
    /** Repository for Article entities. */
    private final ArticleRepository articleRepository;
    /** Repository for Phrase entities. */
    private final PhraseRepository phraseRepository;

    /**
     * Seeds the database with initial data after the application context is initialized.
     * Only seeds if the relevant tables are empty to avoid duplicate entries.
     */
    @PostConstruct
    public void seedDatabase() {
        /*
         * Example seeding logic for Worlds and Levels (currently commented out to prevent duplicates):
         * - Checks if the World and Level tables are empty.
         * - Creates default World entries (Literature, Science, Nature).
         * - Creates default Level entries for each World with sample questions.
         */
        /*// Seed only if database is empty (to prevent duplicates on app restarts)
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
        }*/
        if (articleRepository.count() == 0) {
            articleRepository.saveAll(List.of(
                    newArticle("Start Your Day with Intention for Greater Clarity and Purpose",
                            """
                                    Many of us begin our mornings rushing through routines, barely aware of how our day will unfold. Instead of diving headfirst into your tasks, try pausing for a few minutes to set a clear intention for the day ahead. This simple yet powerful habit can completely transform your experience and mindset.
                                    
                                    Starting your day with intention means taking a moment to ask yourself meaningful questions like: What do I want to feel today? What are the most important things I want to accomplish? What moments do I want to appreciate? These reflections shift your brain from autopilot mode—where you’re reacting to whatever happens—to a more conscious, purposeful mindset. When you take control of your mental state early on, you create space for calm, focus, and clarity.
                                    
                                    Having a daily intention aligns your energy with your true priorities rather than distractions or obligations. This alignment not only boosts your productivity but also improves your overall well-being. When your actions reflect what matters most to you, you’re less likely to feel overwhelmed or burnt out. Instead, your day flows with meaning and direction.
                                    
                                    Practicing intention-setting each morning also strengthens your connection with yourself. It’s a moment to check in, acknowledge your feelings, and tune into your inner voice. Over time, this habit helps you become more self-aware and resilient in the face of challenges.
                                    
                                    Incorporating intention into your morning routine doesn’t need to be complicated—just a few mindful minutes are enough. Whether through journaling, meditation, or quiet reflection, committing to this daily ritual can help you face each day with renewed purpose, clarity, and calm.""",
                            "Maya Reynolds",
                            LocalDate.now()),

                    newArticle("The Power of Micro Habits: Small Steps Toward Lasting Change",
                            """
                                    When it comes to making positive changes in our lives, many of us believe that success requires grand gestures or massive efforts. However, the true key to transformation often lies in something much smaller: micro habits. These tiny, simple actions—such as doing five push-ups, reading one page of a book, or writing just one sentence—may seem insignificant on their own. Yet, when practiced consistently, they hold incredible power to shape your future.
                                    
                                    Micro habits work because they reduce the resistance we often feel toward change. Big goals can feel overwhelming, leading to procrastination or giving up altogether. But small actions are easy to fit into your day and don’t require much motivation. This simplicity makes it easier to start and keep going, which is essential for building lasting habits.
                                    
                                    Over time, these small behaviors accumulate, creating momentum that leads to meaningful progress. The cumulative impact of doing just a little every day often exceeds the results of occasional intense efforts. For example, reading one page a day might not seem like much, but in a year, that adds up to dozens of books completed. Similarly, a few push-ups daily gradually build strength and endurance without the risk of burnout.
                                    
                                    Another advantage of micro habits is their ability to maintain motivation. Because these habits are manageable, you experience regular wins that reinforce positive behavior. This steady encouragement helps you stay on track, even during difficult periods.
                                    
                                    Ultimately, micro habits create a sustainable approach to personal growth. By embracing small, consistent actions, you set yourself up for long-term success and change that sticks—one tiny step at a time.""",
                            "Lucas Bennett",
                            LocalDate.now()),

                    newArticle("Mindfulness in One Breath: A Simple Tool to Calm Your Mind",
                            """
                                    In the rush of daily life, feelings of overwhelm and stress can quickly build up. When emotions run high, it can be challenging to regain balance and clarity. Fortunately, one of the most powerful tools to calm your mind and reset your focus requires nothing more than a single, mindful breath.
                                    
                                    Mindfulness in one breath means pausing to inhale and exhale with full awareness. Instead of breathing automatically or shallowly, you slow down and pay attention to the sensation of your breath entering and leaving your body. This simple act anchors you firmly in the present moment, gently pulling your focus away from worries about the past or future.
                                    
                                    Taking this conscious pause during moments of tension activates your body’s natural relaxation response. It slows your heart rate, reduces stress hormones, and helps calm your nervous system. As a result, you feel more grounded and in control of your emotions. This is especially helpful when anxiety or frustration threatens to overwhelm you.
                                    
                                    The beauty of this practice is its accessibility—you don’t need special equipment, a quiet room, or even a lot of time. Just one mindful breath can create a meaningful shift in how you feel. When incorporated regularly, it becomes a powerful habit that supports your emotional well-being and resilience.
                                    
                                    Next time you feel stressed, overwhelmed, or scattered, try stopping and taking one slow, intentional breath. Notice how your body softens, your mind clears, and you reconnect with yourself. Over time, this simple practice can transform how you navigate life’s challenges—one breath at a time.""",
                            "Olivia Harper",
                            LocalDate.now()),

                    newArticle("Why Reading Daily Matters: Small Time, Big Impact",
                            """
                                    In today’s fast-paced world, carving out time for reading may feel like a luxury. However, making reading a daily habit—even for just ten minutes—can bring profound benefits to your mind and spirit. This simple practice is an investment in your personal growth that pays off over time in surprising ways.
                                    
                                    Consistently reading every day adds up quickly. Ten minutes might not seem like much, but over a year, it can amount to completing more than a dozen books. That’s dozens of new ideas, stories, and perspectives absorbed into your life, expanding your understanding of the world and enhancing your empathy toward others. Each book offers a unique window into different experiences, cultures, and ways of thinking, broadening your horizons far beyond your daily routine.
                                    
                                    Beyond knowledge, reading daily stimulates your brain in powerful ways. It improves your focus and concentration, sharpening mental clarity. The act of immersing yourself in a story or an article also reduces stress by providing a healthy escape from the pressures of everyday life. Studies have shown that even a few minutes of reading can lower your heart rate and ease tension.
                                    
                                    Moreover, reading fuels your imagination and creativity. Engaging with new ideas sparks curiosity and inspires you to think differently. This mental stimulation can enhance problem-solving skills and help you approach challenges with fresh insight.
                                    
                                    Making space to read every day doesn’t require hours on end—just a consistent, intentional commitment to slow down and nourish your mind. Over time, this habit becomes a source of joy, wisdom, and emotional well-being that enriches your life in countless ways.""",
                            "Ethan Cole",
                            LocalDate.now()),

                    newArticle("Digital Detox, Mini Edition: Taking Small Breaks for Big Mental Health Benefits",
                            """
                                    In today’s hyper-connected world, our smartphones and devices often dominate our attention. Notifications, messages, and endless scrolling can easily lead to mental fatigue and increased anxiety. While a full digital detox might sound daunting, even a brief, fifteen-minute break from screens can have a surprisingly powerful impact on your mental health and well-being.
                                    
                                    Taking just fifteen minutes to put your phone away allows your brain a chance to rest and recharge. Without the constant barrage of digital stimuli, you create space to reconnect with yourself and your immediate environment. This mini detox can be spent walking outside, practicing mindful breathing, or simply observing the sights and sounds around you. These simple activities help calm your nervous system, reducing feelings of stress and anxiety.
                                    
                                    In an age where we are continuously “on,” learning to disconnect—even for short periods—is essential. This break can improve your ability to focus and concentrate by giving your mind a rest from multitasking and information overload. Over time, incorporating these mini detoxes into your daily routine can boost productivity and foster a sense of calm balance in your life.
                                    
                                    Moreover, stepping away from screens briefly encourages greater presence and awareness. Instead of getting lost in digital distractions, you become more attuned to your thoughts, feelings, and surroundings. This mindfulness supports emotional resilience and overall mental wellness.
                                    
                                    Incorporating a digital detox mini session into your day doesn’t require major effort—just a simple commitment to pause and unplug for a moment. These small, intentional breaks can make a big difference, helping you feel refreshed, focused, and more connected to the world around you.""",
                            "Sophia Mitchell",
                            LocalDate.now()),

                    newArticle("Small Wins Build Confidence: The Power of Daily Progress",
                            """
                                    When striving toward goals, it’s easy to feel overwhelmed by the big picture. The pressure to achieve everything all at once can lead to frustration or even paralysis. However, the secret to sustained motivation and success often lies in embracing small wins—those everyday achievements that, while modest, carry powerful momentum.
                                    
                                    Completing one meaningful task each day can create a positive ripple effect that boosts your confidence and motivation. These small victories remind you that progress is happening, even if it doesn’t feel monumental at the moment. Over time, this consistent sense of achievement builds a foundation of self-trust and belief in your ability to succeed.
                                    
                                    Celebrating daily wins, no matter how minor, nurtures a positive and productive mindset. Instead of focusing on what remains unfinished, you shift your attention to what you’ve accomplished. This shift creates a mental environment that supports growth and resilience, making it easier to tackle bigger challenges ahead.
                                    
                                    Small wins also help reduce feelings of overwhelm. By breaking down your goals into manageable pieces, you make progress more approachable and less intimidating. Each completed task, no matter how simple, serves as proof that you’re moving forward and capable of change.
                                    
                                    Remember, steady progress—even if slow—is the key to reaching any goal. Success is not always about dramatic leaps but often about the cumulative impact of small, consistent actions. So, take time to recognize and celebrate your daily achievements. These small wins will fuel your confidence and keep you motivated on the journey to your larger dreams.""",
                            "Noah Carter",
                            LocalDate.now()),

                    newArticle("The 2-Minute Rule: A Simple Strategy to Boost Productivity",
                            """
                                    In the whirlwind of daily tasks, it’s easy to let small chores pile up, creating clutter both physically and mentally. The 2-Minute Rule offers a straightforward, effective way to stay ahead of this buildup and improve your productivity with minimal effort. The rule is simple: if a task can be done in two minutes or less, do it immediately.
                                    
                                    Whether it’s replying to a quick message, washing a cup, or putting away something out of place, handling these small tasks right away prevents them from accumulating and overwhelming you later. This approach keeps your environment tidy and your mind clearer, reducing stress and mental overload.
                                    
                                    One of the greatest benefits of the 2-Minute Rule is how it combats procrastination. Small tasks often feel insignificant and easy to postpone, but leaving them undone can create a domino effect of unfinished business. By addressing them promptly, you break the cycle of delay and maintain control over your daily responsibilities.
                                    
                                    Incorporating this habit into your routine not only keeps things organized but also enhances your overall focus. When minor tasks are quickly completed, you free up mental space to concentrate on more important, complex projects without distraction. This clarity helps you prioritize effectively and work more efficiently.
                                    
                                    The beauty of the 2-Minute Rule is its simplicity and accessibility. You don’t need special tools or time blocks—just a willingness to take immediate action on small tasks as they arise. Over time, this habit fosters a sense of accomplishment and order that can significantly boost your productivity and well-being.
                                    
                                    Start applying the 2-Minute Rule today, and experience how small actions can lead to big improvements in your daily life.""",
                            "Ava Thompson",
                            LocalDate.now()),

                    newArticle("The Magic of Walking: Simple Steps to Boost Your Well-Being",
                            """
                                    Walking is one of the simplest activities we can do, yet it’s often underestimated in its ability to improve both our physical and mental health. You don’t need a gym membership or fancy equipment—just a pair of comfortable shoes and a willingness to take a few steps. Even a brief ten-minute walk can make a big difference in how you feel.
                                    
                                    One of the greatest benefits of walking is its ability to clear your mind. When you step outside and move your body, you create space away from stressful thoughts and digital distractions. This mental break helps reduce anxiety and promotes a sense of calm. Many people find that walking sparks creativity, allowing fresh ideas to flow more freely when their mind is not stuck behind a screen or overwhelmed by daily worries.
                                    
                                    Walking also offers physical benefits that contribute to overall well-being. It boosts circulation, strengthens muscles, and supports cardiovascular health without placing excessive strain on your body. It’s an accessible form of exercise suitable for nearly everyone, regardless of age or fitness level.
                                    
                                    Beyond the physical and mental health perks, walking helps you connect with your environment. Whether you stroll through a park, down city streets, or simply around your neighborhood, this activity encourages mindfulness and presence. You become more aware of your surroundings, the sounds, sights, and sensations, which helps ground you in the present moment.
                                    
                                    Making walking a daily habit is a gentle, enjoyable way to recharge your energy and break from routine. Its magic lies in its simplicity—a small, consistent step that naturally enhances your well-being and enriches your day.""",
                            "Liam Brooks",
                            LocalDate.now()),

                    newArticle("Evening Reset Ritual: Preparing Your Mind and Body for Restful Sleep",
                            """
                                    A peaceful night’s sleep is essential for overall health, yet many of us struggle to unwind and prepare for rest after a busy day. Creating an evening reset ritual—a simple set of habits to calm your mind and body before bed—can significantly improve the quality of your sleep and help you wake up refreshed and energized.
                                    
                                    One of the first steps in an effective evening ritual is to dim bright lights. Exposure to harsh or blue light from screens and overhead bulbs can interfere with your body’s natural production of melatonin, the hormone that regulates sleep. By softening the lighting in your space, you signal to your brain that it’s time to slow down and prepare for rest.
                                    
                                    Silencing notifications is another crucial step. The constant ping of messages or alerts can keep your mind alert and distracted, making it harder to relax. Turning off or muting devices allows you to create a calm environment, free from interruptions.
                                    
                                    Taking a moment to reflect on something positive from your day adds an important emotional component to your ritual. Practicing gratitude before sleep helps shift your focus away from stress or worries, replacing them with feelings of appreciation and calm. This mindset not only promotes relaxation but also fosters emotional well-being.
                                    
                                    Incorporating these small but intentional actions into your nightly routine helps close the day on a peaceful note. Over time, this ritual becomes a powerful signal to your body and mind that it’s time to rest, leading to deeper, more restorative sleep.
                                    
                                    With better sleep quality, you’ll wake up with improved energy, clarity, and mood—ready to face a new day with a fresh perspective.""",
                            "Isabella Foster",
                            LocalDate.now()),

                    newArticle("Focus: One Task at a Time for Better Productivity and Calm",
                            """
                                    In today’s fast-paced world, multitasking is often seen as a way to get more done. However, studies show that juggling multiple tasks at once can actually exhaust your brain, reduce efficiency, and increase stress. Instead, focusing on one task at a time—a practice called monotasking—can help you work smarter, finish faster, and produce higher-quality results.
                                    
                                    When you give a single task your full attention, your brain can engage more deeply with the work. This concentrated effort means fewer mistakes, better problem-solving, and greater creativity. Multitasking, by contrast, forces your brain to constantly switch gears, which drains mental energy and slows overall progress.
                                    
                                    Monotasking not only boosts productivity but also lowers stress. Trying to keep track of several things at once can leave you feeling overwhelmed and scattered. By dedicating yourself to one task until completion, you reduce mental clutter and foster a calmer, more focused state of mind.
                                    
                                    Practicing this approach regularly strengthens your ability to concentrate over time. As your focus improves, you’ll find it easier to resist distractions and stay on track, whether you’re working, studying, or managing daily responsibilities.
                                    
                                    This single-task focus also enhances your overall satisfaction with your work. Completing tasks fully and thoroughly brings a sense of accomplishment and control that multitasking rarely offers. It transforms your daily experience from hectic to mindful.
                                    
                                    To start monotasking, try breaking your day into focused blocks of time where you commit to just one task. Turn off notifications, close unnecessary tabs, and give yourself permission to focus deeply. Over time, this simple habit will help you achieve more with less stress, creating a more balanced and fulfilling workflow.""",
                            "Mason Clarke",
                            LocalDate.now()),

                    newArticle("Slow Down to Speed Up: The Power of Mindful Pace",
                            """
                                    In today’s fast-paced society, speed is often praised as the key to success. We rush from one task to another, juggling deadlines and commitments, believing that moving faster will get us ahead. However, learning to slow down is a surprisingly powerful strategy that can improve both your productivity and well-being.
                                    
                                    Slowing down means taking your time with each task and allowing yourself moments to breathe between actions. This mindful approach reduces stress by preventing the overwhelm that comes with rushing. When you move too quickly, it’s easy to make mistakes or overlook important details. Taking a deliberate pace helps you stay focused and accurate, ultimately saving time and energy in the long run.
                                    
                                    This practice of slowing down enhances your clarity and decision-making. When you’re not racing against the clock, you can fully engage with what you’re doing and think more deeply. This often leads to higher-quality work and more creative solutions. Instead of reacting impulsively, you respond thoughtfully.
                                    
                                    Slowing down doesn’t mean wasting time or falling behind. On the contrary, it’s about optimizing your time and energy so you can get more done without burnout. When you’re patient and present, your efficiency naturally improves. You’ll notice that tasks flow more smoothly, and your motivation stays higher.
                                    
                                    Incorporating moments of calm and intentional pacing into your day can transform how you work and live. By practicing patience, you create a rhythm that supports sustainable progress and well-being.
                                    
                                    Next time you feel rushed, try slowing down and taking a breath. You might just find that slowing down is the fastest way to move forward.""",
                            "Emma Hayes",
                            LocalDate.now()),

                    newArticle("Rest is Productive: Why Taking Breaks Boosts Performance",
                            """
                                    In a culture that often glorifies nonstop work, rest can be mistakenly seen as laziness. However, rest is actually a crucial part of maintaining peak performance, creativity, and overall well-being. Recognizing that resting is productive helps you work smarter and stay healthier over time.
                                    
                                    Taking short breaks throughout your day gives your brain a chance to recharge. Continuous work without pauses leads to mental fatigue, reducing your ability to focus and solve problems effectively. When you allow yourself to step away, even briefly, you reset your cognitive resources and improve your mental clarity.
                                    
                                    These rest periods don’t have to be long or complicated. Simple activities like stretching, walking, or practicing mindful breathing can refresh your mind and body. By incorporating regular breaks, you prevent burnout—a state of emotional and physical exhaustion that can seriously hinder your productivity and happiness.
                                    
                                    Rest also supports creativity. When your brain has downtime, it can process information in the background, make new connections, and generate fresh ideas. Many great insights come when you’re not actively working but resting or engaging in different activities.
                                    
                                    Embracing rest as part of your productivity routine means shifting your mindset. Instead of pushing yourself relentlessly, you balance work with intentional pauses that fuel sustained energy and motivation.
                                    
                                    Over the long term, this approach benefits both your physical health and mental resilience. You’ll notice improved concentration, better mood, and a more enjoyable work experience.
                                    
                                    So, next time you feel guilty about taking a break, remember that rest is not a break from productivity—it’s an essential component of it. By valuing rest, you set yourself up for success in every area of life.""",
                            "Jacob Lawson",
                            LocalDate.now())
            ));
        }

        if (phraseRepository.count() == 0) {
            phraseRepository.saveAll(List.of(
                    newPhrase("Start Your Day with Intention",
                            """
                                    Instead of rushing into your day, take 2 minutes to set an intention.\s
                                    Ask yourself: What’s one thing I want to feel, do, or appreciate today?\s
                                    This simple practice helps shift your mind from autopilot to awareness.""",
                            LocalDate.now()),

                    newPhrase("The Power of Micro Habits",
                            """
                                    You don’t need a full workout to get healthier. Just do 5 pushups.\s
                                    Read one page. Write one sentence. These “micro habits” bypass resistance\s
                                    and build consistency over time — turning into real change.""",
                            LocalDate.now()),

                    newPhrase("Mindfulness in One Breath",
                            """
                                    Feeling overwhelmed? Pause. Take one deep breath and notice it fully.\s
                                    Feel the air coming in, feel it going out. This moment of awareness is mindfulness.\s
                                    You just practiced it.""",
                            LocalDate.now()),

                    newPhrase("Why Reading Daily Matters",
                            """
                                    Reading 10 minutes a day may seem small, but it adds up.\s
                                    Over a year, that’s more than 12 full-length books.\s
                                    Reading exercises your brain, reduces stress, and boosts empathy.""",
                            LocalDate.now()),

                    newPhrase("Digital Detox, Mini Edition",
                            """
                                    Try putting your phone away for 15 minutes — no scrolling, no checking.\s
                                    Use that time to walk, breathe, or just look out a window.\s
                                    Your mind will thank you.""",
                            LocalDate.now()),

                    newPhrase("Small Wins Build Confidence",
                            """
                                    You don’t need to conquer your entire to-do list.\s
                                    Just complete one meaningful task. One small win creates momentum —\s
                                    and makes the next one easier.""",
                            LocalDate.now()),

                    newPhrase("The 2-Minute Rule",
                            """
                                    If a task takes less than 2 minutes, do it now.\s
                                    Reply to that message. Wash that cup. These quick wins prevent clutter\s
                                    and boost mental clarity.""",
                            LocalDate.now()),

                    newPhrase("The Magic of Walking",
                            "Walking is underrated. Just 10 minutes clears your mind, reduces stress, \n" +
                                    "and even boosts creativity. No gym required. No special gear. Just walk.",
                            LocalDate.now()),

                    newPhrase("Evening Reset Ritual",
                            """
                                    Before bed, try a short ritual: dim the lights, silence notifications,\s
                                    and reflect on one good thing from your day.\s
                                    You’ll sleep better — and end the day with gratitude.""",
                            LocalDate.now()),

                    newPhrase("Focus: One Task at a Time",
                            """
                                    Multitasking feels productive, but it drains your brain.\s
                                    Try monotasking: focus on one thing, fully.\s
                                    You’ll finish faster — and feel calmer doing it.""",
                            LocalDate.now()),

                    newPhrase("Slow Down to Speed Up",
                            """
                                    In a world of speed, slowing down is a superpower.\s
                                    Take your time with one task. Breathe between actions.\s
                                    You'll find yourself getting more done — with less stress.""",
                            LocalDate.now()),

                    newPhrase("Books Are Brain Food",
                            """
                                    Reading isn’t just fun — it feeds your brain.\s
                                    Fiction improves empathy. Nonfiction sharpens thinking.\s
                                    Even short reads stimulate imagination.""",
                            LocalDate.now()),

                    newPhrase("Rest is Productive",
                            """
                                    Rest isn’t laziness — it’s fuel.\s
                                    Taking short breaks during the day helps your brain reset,\s
                                    preventing burnout and increasing creativity.""",
                            LocalDate.now()),

                    newPhrase("Gratitude in 3 Sentences",
                            """
                                    Think of 3 things you’re grateful for right now.\s
                                    Say them out loud or write them down.\s
                                    This small practice rewires your brain for optimism.""",
                            LocalDate.now()),

                    newPhrase("Your Environment Shapes You",
                            """
                                    Want to build better habits? Design your space.\s
                                    Put books where you can see them. Hide your phone during work.\s
                                    What’s visible gets done.""",
                            LocalDate.now()),

                    newPhrase("Replace Reacting with Responding",
                            """
                                    Someone annoys you? Pause. Breathe.\s
                                    Choose your response instead of reacting instantly.\s
                                    This is how you train emotional intelligence.""",
                            LocalDate.now()),

                    newPhrase("Be Kind to Yourself",
                            """
                                    You won’t always get it right. That’s normal.\s
                                    Progress is messy — and that’s okay.\s
                                    Talk to yourself like you would a friend.""",
                            LocalDate.now()),

                    newPhrase("Breathe Like It Matters",
                            """
                                    Breathing is automatic — but conscious breathing is powerful.\s
                                    Try 4-7-8: inhale for 4, hold for 7, exhale for 8.\s
                                    It calms your nervous system fast.""",
                            LocalDate.now()),

                    newPhrase("Celebrate Tiny Progress",
                            """
                                    Did you stretch today? Meditate for a minute?\s
                                    That counts. Celebrate it.\s
                                    Small wins repeated daily turn into transformation.""",
                            LocalDate.now()),

                    newPhrase("You Don’t Need to Hustle All the Time",
                            """
                                    Rest is not a reward — it's a requirement.\s
                                    The best ideas often come when you're not trying too hard.\s
                                    Let your brain breathe.""",
                            LocalDate.now())
            ));
        }
    }

    /**
     * Helper method to create and save a new World entity.
     * @param name the name of the world
     * @param order the display order index
     * @param worldRepository the repository to save the world
     * @return the saved World entity
     */
    private World createWorld(String name, int order, WorldRepository worldRepository) {
        World world = new World();
        world.setName(name);
        world.setOrderIndex(order);
        return worldRepository.save(world);
    }

    /**
     * Helper method to create a new Level entity.
     * @param number the level number
     * @param question the quiz question
     * @param op1 option 1
     * @param op2 option 2
     * @param op3 option 3
     * @param op4 option 4
     * @param correct the index of the correct answer (1-4)
     * @param world the World this level belongs to
     * @return the constructed Level entity
     */
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

    /**
     * Helper method to create a new Article entity.
     * @param title the article title
     * @param content the article content
     * @param author the article author
     * @param date the publication date
     * @return the constructed Article entity
     */
    private Article newArticle(String title, String content, String author, LocalDate date) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        article.setDate(date);
        return article;
    }

    /**
     * Helper method to create a new Phrase entity.
     * @param title the phrase title
     * @param content the phrase content
     * @param date the date associated with the phrase
     * @return the constructed Phrase entity
     */
    private Phrase newPhrase(String title, String content, LocalDate date) {
        Phrase phrase = new Phrase();
        phrase.setTitle(title);
        phrase.setContent(content);
        phrase.setDate(date);
        return phrase;
    }
}

