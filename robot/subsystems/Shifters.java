// package frc.robot.subsystems;
// import edu.wpi.first.wpilibj.Compressor;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
// import edu.wpi.first.wpilibj.PneumaticsModuleType;




// public class Shifters {
//     DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 7);
//     //DoubleSolenoid exampleDoublePH = new DoubleSolenoid(8, PneumaticsModuleType.REVPH, 1, 6);
//     Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
//     //Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);

    
//     boolean enabled = pcmCompressor.isEnabled();
//     boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
//     double current = pcmCompressor.getCurrent();
    
//     // Solenoid exampleSingle = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
//     DoubleSolenoid exampleDouble = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

// // Initialize the DoubleSolenoid so it knows where to start.  Not required for single solenoids.


//     Shifters(){
//         exampleDouble.set(kReverse);
//         exampleDoublePCM.set(kOff);
//         exampleDoublePCM.set(kReverse);
//         exampleDoublePCM.set(kForward);
//         pcmCompressor.enableDigital();
//         pcmCompressor.disable();
//     }
    
// }
