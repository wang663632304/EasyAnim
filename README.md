EasyAnim
========

A less painful way of doing View animations in Android.
(A subclass of AnimationSet)

Features
--------------
- Easier setup/smart defaults without losing customizability
- Automagically animates from the previous animation position to the new animation position
- Ability to add transformations to existing transformations

Note: In order for the animation features to work properly, EasyAnim should not be mixed with standard Android View animations.

Usage Example
--------------
View myView = ....
EasyAnim anim = new EasyAnim(true, myView); 
anim.setTranslate(30f, 30f);  
anim.setScale(1.5f, 1.5f);
anim.setRotation(360f);
anim.setAlpha(.8f);
anim.setAddToExistingTransform(true); 
anim.finishAnimationSetup();    // Have to call this method before applying the animation
myView.startAnimation(anim);

