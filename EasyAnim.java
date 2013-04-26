package com.brilliantchemistry.betterclasses;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Interpolator;


// TODO : Add support for scaling from different origins and rotating around different points

@SuppressLint("UseValueOf")  //what a stupid warning.
public class EasyAnim extends AnimationSet {	
	private static long DEFAULT_ANIMATION_DURATION = 400;
	
	public String animName;
	
	private boolean shareInterp;
	
	private Float scaleX;
	private Float previousScaleX;
	private Float scaleY;
	private Float previousScaleY;
	private Float scaleDelay;
	private Float scaleDuration;
	private Interpolator scaleInterpolator;
	
	private Float x;
	private Float previousX;
	private Float y;
	private Float previousY;
	private Float translateDelay;
	private Float translateDuration;
	private Interpolator translateInterpolator;
	
	private Float alpha;
	private Float previousAlpha;
	private Float alphaDelay;
	private Float alphaDuration;
	private Interpolator alphaInterpolator;
	
	private Float rotation;
	private Float previousRotation;
	private Float rotationDelay;
	private Float rotationDuration;
	private Interpolator rotationInterpolator;
	
	private boolean addToExistingTransform;
	
	public EasyAnim(boolean shareInterpolator) {
		super(shareInterpolator);
		
		this.finishInitialization();
	}
	
	public EasyAnim(boolean shareInterpolator, View v) {
		super(shareInterpolator);
		this.shareInterp = shareInterpolator;
		
		this.finishInitialization();
		
		Animation previousAnim = v.getAnimation();
		if(previousAnim != null) {
			if(previousAnim instanceof EasyAnim) {				
				EasyAnim anim = (EasyAnim)previousAnim;
				this.previousScaleX = anim.getFinalScaleX();
				this.previousScaleY = anim.getFinalScaleY();
				this.previousX = anim.getFinalX();
				this.previousY = anim.getFinalY();
				this.previousAlpha = anim.getFinalAlpha();
				this.previousRotation = anim.getFinalRotation();					
			}
		}
	}
	
	private void finishInitialization() {
		this.setAddToExistingTransform(false);
		this.setInterpolator(new AccelerateDecelerateInterpolator());
		
		this.setFillAfter(true);
		this.setFillEnabled(true);
		this.setDuration(DEFAULT_ANIMATION_DURATION);
		
		this.scaleX = null;
		this.scaleY = null;
		this.scaleDelay = null;
		this.scaleDuration = null;
		this.scaleInterpolator = null;
				
		this.x = null;
		this.y = null;
		this.translateDelay = null;
		this.translateDuration = null;
		this.translateInterpolator = null;
		
		this.alpha = null;
		this.alphaDelay = null;
		this.alphaDuration = null;
		this.alphaInterpolator = null;
		
		this.rotation = null;
		this.rotationDelay = null;
		this.rotationDuration = null;
		this.rotationInterpolator = null;
		
		this.animName = "MyAnim!!";
	}

	@Override
	public void reset() {
		super.reset();		
	}
	
	private void softReset() {
		super.reset();
	}
	
	private Float getFinal(Float previous, Float current, boolean shouldMultiplyIfNeeded) {
		Float value = null;
		
		
		if(this.shouldAddToExistingTransform()) {
			value = previous;
		}
		
		if(current != null) {
			if(value != null) {
				if(shouldMultiplyIfNeeded)
					value = new Float(value.floatValue() * current.floatValue());
				else
					value = new Float(value.floatValue() + current.floatValue());
			}
			else
				value = new Float(current.floatValue());
		}
		
		return value;
	}

	
	public Float getScaleX() {
		return scaleX;
	}
	
	public Float getFinalScaleX() {
		return this.getFinal(previousScaleX, scaleX, true);
	}

	public void setScale(Float x, Float y) {
		this.scaleX = x;
		this.scaleY = y;
	}

	public Float getScaleY() {
		return scaleY;
	}
	
	public Float getFinalScaleY() {
		return this.getFinal(previousScaleY, scaleY, true);
	}

	public Float getPreviousScaleX() {
		return previousScaleX;
	}

	public Float getPreviousScaleY() {
		return previousScaleY;
	}

	public Float getScaleDelay() {
		return scaleDelay;
	}

	public void setScaleDelay(Float scaleDelay) {
		this.scaleDelay = scaleDelay;
	}

	public Float getScaleDuration() {
		return scaleDuration;
	}

	public void setScaleDuration(Float scaleDuration) {
		this.scaleDuration = scaleDuration;
	}

	public Interpolator getScaleInterpolator() {
		return scaleInterpolator;
	}

	public void setScaleInterpolator(Interpolator scaleInterpolator) {
		this.scaleInterpolator = scaleInterpolator;
	}

	public Float getX() {
		return x;
	}
	
	public Float getFinalX() {
		return this.getFinal(previousX, x, false);
	}

	public void setTranslate(Float x, Float y) {
		this.x = x;
		this.y = y;
	}

	public Float getY() {
		return y;
	}
	
	public Float getFinalY() {
		return this.getFinal(previousY, y, false);
	}

	public Float getTranslateDelay() {
		return translateDelay;
	}

	public void setTranslateDelay(Float translateDelay) {
		this.translateDelay = translateDelay;
	}

	public Float getTranslateDuration() {
		return translateDuration;
	}

	public void setTranslateDuration(Float translateDuration) {
		this.translateDuration = translateDuration;
	}

	public Interpolator getTranslateInterpolator() {
		return translateInterpolator;
	}

	public void setTranslateInterpolator(Interpolator translateInterpolator) {
		this.translateInterpolator = translateInterpolator;
	}

	public Float getAlpha() {
		return alpha;
	}
	
	public Float getFinalAlpha() {
		return this.getFinal(previousAlpha, alpha, true);
	}

	public void setAlpha(Float alpha) {
		this.alpha = alpha;
	}

	public Float getAlphaDelay() {
		return alphaDelay;
	}

	public void setAlphaDelay(Float alphaDelay) {
		this.alphaDelay = alphaDelay;
	}

	public Float getAlphaDuration() {
		return alphaDuration;
	}

	public void setAlphaDuration(Float alphaDuration) {
		this.alphaDuration = alphaDuration;
	}

	public Interpolator getAlphaInterpolator() {
		return alphaInterpolator;
	}

	public void setAlphaInterpolator(Interpolator alphaInterpolator) {
		this.alphaInterpolator = alphaInterpolator;
	}

	public Float getRotation() {
		return rotation;
	}
	
	public Float getFinalRotation() {
		return this.getFinal(previousRotation, rotation, false);
	}

	public void setRotation(Float rotation) {
		this.rotation = rotation;
	}

	public Float getRotationDelay() {
		return rotationDelay;
	}

	public void setRotationDelay(Float rotationDelay) {
		this.rotationDelay = rotationDelay;
	}

	public Float getRotationDuration() {
		return rotationDuration;
	}

	public void setRotationDuration(Float rotationDuration) {
		this.rotationDuration = rotationDuration;
	}

	public Interpolator getRotationInterpolator() {
		return rotationInterpolator;
	}

	public void setRotationInterpolator(Interpolator rotationInterpolator) {
		this.rotationInterpolator = rotationInterpolator;
	}

	public boolean shouldAddToExistingTransform() {
		return addToExistingTransform;
	}

	public void setAddToExistingTransform(boolean addToExistingTransform) {
		this.addToExistingTransform = addToExistingTransform;
	}
	
	private void setupAnimWithDurationAndCurve(Animation anim, Float duration, Float delay, Interpolator interp) {
		if(duration != null)
			anim.setDuration((long) duration.floatValue());
		else
			anim.setDuration(this.getDuration());
		
		if(delay != null)
			anim.setStartOffset((long) delay.floatValue());
		else
			anim.setStartOffset(this.getStartOffset());
		
		if(!this.shareInterp) {
			if(interp != null) {
				anim.setInterpolator(interp);
			}
			else {
				anim.setInterpolator(this.getInterpolator());
			}
		}
	}
	
	private ScaleAnimation getScaleAnim() {
		ScaleAnimation anim = null;
		
		Float finalScaleX = this.getFinalScaleX();
		Float finalScaleY = this.getFinalScaleY();
		
		if(finalScaleX != null || finalScaleY != null) {
			float x = 1;
			float y = 1;
			if(finalScaleX != null)
				x = finalScaleX.floatValue();
			
			if(finalScaleY != null)
				y = finalScaleY.floatValue();
			
			float previousX = 1;
			float previousY = 1;
			if(this.previousScaleX != null)
				previousX = this.previousScaleX.floatValue();
			if(this.previousScaleY != null)
				previousY = this.previousScaleY.floatValue();
			
			anim = new ScaleAnimation(previousX, x, previousY, y, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			this.setupAnimWithDurationAndCurve(anim, scaleDuration, scaleDelay, scaleInterpolator);
		}
		
		return anim;
	}
	
	private TranslateAnimation getTranslateAnim() {
		TranslateAnimation anim = null;
		
		Float finalX = this.getFinalX();
		Float finalY = this.getFinalY();
		
		if(finalX != null || finalY != null) {
			float x = 1;
			float y = 1;
			if(finalX != null)
				x = finalX.floatValue();
			
			if(finalY != null)
				y = finalY.floatValue();
			
			float previousX = 1;
			float previousY = 1;
			if(this.previousX != null)
				previousX = this.previousX.floatValue();
			if(this.previousY != null)
				previousY = this.previousY.floatValue();
			
			anim = new TranslateAnimation(previousX, x, previousY, y);
			this.setupAnimWithDurationAndCurve(anim, translateDuration, translateDelay, translateInterpolator);
		}
		
		return anim;
	}
	
	private AlphaAnimation getAlphaAnim() {
		AlphaAnimation alphaAnim = null;
		
		Float finalAlpha = this.getFinalAlpha();
		
		if(finalAlpha != null) {
			float alpha = finalAlpha.floatValue();
			
			float previousAlpha = 1;
			if(this.previousAlpha != null)
				previousAlpha = this.previousAlpha.floatValue();
			
			alphaAnim = new AlphaAnimation(previousAlpha, alpha);
			this.setupAnimWithDurationAndCurve(alphaAnim, alphaDuration, alphaDelay, alphaInterpolator);
		}
		
		return alphaAnim;
	}
	
	private RotateAnimation getRotationAnim() {
		RotateAnimation rotationAnim = null;
		
		Float finalRotation = this.getFinalRotation();
		
		if(finalRotation != null) {
			float rotation = finalRotation.floatValue();
			
			float previousRotation = 0;
			if(this.previousRotation != null)
				previousRotation = this.previousRotation.floatValue();
			
			rotationAnim = new RotateAnimation(previousRotation, rotation, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			this.setupAnimWithDurationAndCurve(rotationAnim, rotationDuration, rotationDelay, rotationInterpolator);
		}
		
		return rotationAnim;
	}
	
	public void finishAnimationSetup() {
		this.softReset();  //make sure we reset the animation stack used by the AnimationSet class, but not the currently set transform values.
		
		TranslateAnimation translateAnim = this.getTranslateAnim();
		ScaleAnimation scaleAnim = this.getScaleAnim();
		AlphaAnimation alphaAnim = this.getAlphaAnim();
		RotateAnimation rotationAnim = this.getRotationAnim();
		
		if(translateAnim != null)
			this.addAnimation(translateAnim);
		if(scaleAnim != null)
			this.addAnimation(scaleAnim);
		if(alphaAnim != null)
			this.addAnimation(alphaAnim);
		if(rotationAnim != null)
			this.addAnimation(rotationAnim);
		
	}

}
